package py.com.poraplz.cursomc.module.category.infrastructure.db.jpa;

import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;
import py.com.poraplz.cursomc.module.category.infrastructure.model.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class SpringJpaCategoryAdaptor implements CategoryRepository {
    private final SpringJpaCategoryRepository repository;

    public SpringJpaCategoryAdaptor(SpringJpaCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = CategoryMapper.toEntityFrom(category);
        return CategoryMapper.toObjectValueFrom(
                repository.saveAndFlush(categoryEntity)
        );
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll()
                .stream()
                .map(CategoryMapper::toObjectValueFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<CategoryEntity> optionalCategory = repository.findById(id);
        return optionalCategory.map(CategoryMapper::toObjectValueFrom);

    }
}
