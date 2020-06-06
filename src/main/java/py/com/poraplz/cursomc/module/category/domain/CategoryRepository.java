package py.com.poraplz.cursomc.module.category.domain;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);

    List<Category> getAll();

    Optional<Category> findById(Long id);
}
