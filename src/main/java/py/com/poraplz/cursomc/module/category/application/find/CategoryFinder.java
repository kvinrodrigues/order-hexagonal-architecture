package py.com.poraplz.cursomc.module.category.application.find;

import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.category.application.CategoryResponse;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;

@Service
public final class CategoryFinder {
    private final py.com.poraplz.cursomc.module.category.domain.CategoryFinder finder;

    public CategoryFinder(CategoryRepository repository) {
        this.finder = new
                py.com.poraplz.cursomc.module.category.domain.CategoryFinder(
                repository);
    }

    public CategoryResponse find(Long id) {
        return CategoryResponse.fromAggregate(finder.find(id));
    }
}
