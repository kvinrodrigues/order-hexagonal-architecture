package py.com.poraplz.cursomc.module.category.infrastructure.db.jpa;

import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class CategorySpringJpaAdapter implements CategoryRepository {
    private final CategorySpringJpaRepository repository;

    public CategorySpringJpaAdapter(CategorySpringJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = CategoryMapper.toEntity(category);
        return CategoryMapper.toObjectValue(
                repository.saveAndFlush(categoryEntity)
        );
    }

    @Override
    public void remove(Category category) {
        CategoryEntity categoryEntity = CategoryMapper.toEntity(category);
        repository.delete(categoryEntity);
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll()
                .stream()
                .map(CategoryMapper::toObjectValue)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<CategoryEntity> optionalCategory = repository.findById(id);
        return Optional.of
                (CategoryMapper.toObjectValue(optionalCategory.get())
                );
    }
}
