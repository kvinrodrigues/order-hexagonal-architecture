package py.com.poraplz.cursomc.module.category.application;

import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.shared.domain.bus.query.Response;

public final class CategoryResponse implements Response {
    private Long id;
    private String name;

    private CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryResponse fromAggregate(Category category) {
        return new CategoryResponse(category.id(), category.name());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
