package py.com.poraplz.cursomc.module.category.application.update;

import org.springframework.stereotype.Service;

import py.com.poraplz.cursomc.module.category.domain.*;

@Service
public final class CategoryRenamer {
    private final py.com.poraplz.cursomc.module.category.domain.CategoryFinder finder;
    private final CategoryRepository repository;

    public CategoryRenamer(CategoryRepository repository) {
        this.repository = repository;
        this.finder = new CategoryFinder(repository);
    }

    public Category rename(Long id, CategoryName name) {
        Category actualCategory = finder.find(id);
        Category updatedCategory = actualCategory.rename(name);
        return repository.save(updatedCategory);
    }
}
