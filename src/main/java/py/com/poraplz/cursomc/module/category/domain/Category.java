package py.com.poraplz.cursomc.module.category.domain;

import py.com.poraplz.cursomc.module.product.domain.Product;

import java.util.List;
import java.util.Objects;

public final class Category {
    private CategoryId categoryId; // TODO DEFINIR SI ES LA MANERA CORRECTA DE MANEJAR PK tipo numerico
    private final CategoryName categoryName;
    private final CategoryProducts categoryProducts = new CategoryProducts();

    private Category(CategoryId categoryId, CategoryName categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    private Category(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public static Category from(CategoryId id, CategoryName name) {
        return new Category(id, name);
    }

    public static Category from(CategoryName name) {
        return new Category(name);
    }

    public Category rename(CategoryName name) {
        return new Category(categoryId, name);
    }

    public CategoryId id() {
        return categoryId;
    }

    public String name() {
        return categoryName.value();
    }

    public List<Product> products() {
        return categoryProducts.products();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                categoryName.equals(category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, categoryProducts);
    }
}
