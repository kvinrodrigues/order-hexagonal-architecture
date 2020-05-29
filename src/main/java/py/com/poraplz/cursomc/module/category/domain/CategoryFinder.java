package py.com.poraplz.cursomc.module.category.domain;

import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;

import java.util.Optional;

public final class CategoryFinder {
    private final CategoryRepository repository;

    public CategoryFinder(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category find(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Category Not Found:" + id));
    }

}
