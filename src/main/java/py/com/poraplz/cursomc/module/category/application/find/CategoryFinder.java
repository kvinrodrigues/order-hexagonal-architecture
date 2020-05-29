package py.com.poraplz.cursomc.module.category.application.find;

import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.category.application.CategoriesDto;
import py.com.poraplz.cursomc.module.category.application.CategoryResponse;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;


@Service
public final class CategoryFinder {
    private final CategoryRepository repository;
    private final py.com.poraplz.cursomc.module.category.domain.CategoryFinder finder;

    public CategoryFinder(CategoryRepository repository) {
        this.repository = repository;
        this.finder = new
                py.com.poraplz.cursomc.module.category.domain.CategoryFinder(
                repository);
    }

    public CategoryResponse find(Long id) {
        return CategoryResponse.fromAggregate(finder.find(id));
    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = repository.getAll();
        return categories
                .stream()
                .map(CategoryResponse::fromAggregate)
                .collect(Collectors.toList());
    }

}
