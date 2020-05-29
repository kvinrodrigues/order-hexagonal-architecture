package py.com.poraplz.cursomc.module.category.infrastructure.db.jpa;

import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryId;
import py.com.poraplz.cursomc.module.category.domain.CategoryName;

public final class CategoryMapper {
    public static Category toObjectValue(CategoryEntity categoryEntity) {
        return Category.from(
                new CategoryId(categoryEntity.getId()),
                new CategoryName(categoryEntity.getName())
        );
    }

    public static CategoryEntity toEntity(Category category) {
        return new CategoryEntity(category.name());
    }
}
