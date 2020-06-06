package py.com.poraplz.cursomc.module.category.application.add;

import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;

@Service
public final class CategorySaver {
    private final CategoryRepository repository;

    public CategorySaver(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category save(Category category) {
        return repository.save(category);
    }

}
