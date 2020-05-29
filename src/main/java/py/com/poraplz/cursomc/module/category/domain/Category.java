package py.com.poraplz.cursomc.module.category.domain;

import py.com.poraplz.cursomc.module.product.domain.Product;

import java.util.List;

public final class Category {
    private final CategoryId categoryId;
    private final CategoryName categoryName;
    private final CategoryProducts categoryProducts;

    private Category(CategoryId categoryId, CategoryName categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        categoryProducts = new CategoryProducts();
    }

    public static Category from(CategoryId id, CategoryName name) {
        return new Category(id, name);
    }

    public Long id() {
        return categoryId.id();
    }

    public String name() {
        return categoryName.value();
    }

    public List<Product> products() {
        return categoryProducts.products();
    }
}
