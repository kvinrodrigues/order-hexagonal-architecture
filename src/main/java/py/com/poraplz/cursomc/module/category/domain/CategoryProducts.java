package py.com.poraplz.cursomc.module.category.domain;

import py.com.poraplz.cursomc.module.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

public final class CategoryProducts {
    private final List<Product> products = new ArrayList<>();

    public List<Product> products() {
        return products;
    }
}
