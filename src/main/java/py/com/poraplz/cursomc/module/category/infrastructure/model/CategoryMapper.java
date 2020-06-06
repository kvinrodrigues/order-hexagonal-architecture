package py.com.poraplz.cursomc.module.category.infrastructure.model;

import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryId;
import py.com.poraplz.cursomc.module.category.domain.CategoryName;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;

public final class CategoryMapper {
    public static Category toObjectValueFrom(CategoryEntity categoryEntity) {
        return Category.from(
                new CategoryId(categoryEntity.getId()),
                new CategoryName(categoryEntity.getName())
        );
    }

    public static CategoryEntity toEntityFrom(Category category) {
        return new CategoryEntity(category.name());
    }

    public static Category toEntityFrom(CategoryRequest request) {
        return Category.from(new CategoryName(request.getName()));
    }
}
