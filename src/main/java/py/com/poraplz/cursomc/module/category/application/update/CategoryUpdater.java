package py.com.poraplz.cursomc.module.category.application.update;

import org.springframework.stereotype.Service;

import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryFinder;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;

@Service
public final class CategoryUpdater {
    private final py.com.poraplz.cursomc.module.category.domain.CategoryFinder finder;
    private final CategoryRepository repository;

    public CategoryUpdater(CategoryRepository repository) {
        this.repository = repository;
        this.finder = new CategoryFinder(repository);
    }

    public Category update(Long id, Category category) {
        finder.find(id);
        return repository.save(category);
    }
}
