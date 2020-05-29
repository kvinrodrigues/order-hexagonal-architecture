package py.com.poraplz.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.category.application.CategoriesDto;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.BrokenDataIntegrity;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategorySpringJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private static final Logger logger = LoggerFactory
            .getLogger(CategoryService.class);

    private CategorySpringJpaRepository repo;

    @Autowired
    public CategoryService(CategorySpringJpaRepository repo) {
        this.repo = repo;
    }

    public CategoryEntity saveOrUpdate(CategoryEntity categoryEntity) {
        try {
            return repo.save(categoryEntity);
        } catch (Exception e) {
            throw (e);
        }
    }

    public CategoryEntity findCategory(Long id) {
        Optional<CategoryEntity> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("No se encontro categoria, id:" + id));
    }

    public CategoryEntity updateCategory(CategoriesDto request, Long id) {
        CategoryEntity categoryEntity = findCategory(id);
        return saveOrUpdate(setDataToUpdate(categoryEntity, request));
    }

    public CategoryEntity setDataToUpdate(CategoryEntity actual, CategoriesDto newValue) {
        actual.setName(newValue.getName());
        actual.setProducts(newValue.getProducts());
        return actual;
    }

    public void deleteCategory(Long id) {
        findCategory(id);
        try {
            repo.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new BrokenDataIntegrity("Ya existen productos con la categoria existente");
        }
    }



    public Page<CategoryEntity> filterCategory(Integer page, Integer linesPerPage, String column
            , String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
                Sort.Direction.valueOf(direction), column);
        return repo.findAll(pageRequest);

    }

    public CategoryEntity fromDtoToCategory(CategoriesDto dto) {
        return new CategoryEntity(dto.getName());
    }
}
