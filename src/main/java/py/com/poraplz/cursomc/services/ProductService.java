package py.com.poraplz.cursomc.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.SpringJpaCategoryRepository;
import py.com.poraplz.cursomc.module.product.domain.ProductRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository repo;
    private SpringJpaCategoryRepository springJpaCategoryRepository;

    public ProductService(ProductRepository repo, SpringJpaCategoryRepository springJpaCategoryRepository){
        this.repo = repo;
        this.springJpaCategoryRepository = springJpaCategoryRepository;
    }

    public ProductEntity findById(Long id){
        Optional<ProductEntity> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("ProductEntity no encontrado, id: "+ id));
    }

    public Page<ProductEntity> search(String name, List<Long> ids, Integer page, Integer linesPerPage,
                                      String column, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), column);
        List<CategoryEntity> categories = springJpaCategoryRepository.findAllById(ids);
        return repo.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
    }
}
