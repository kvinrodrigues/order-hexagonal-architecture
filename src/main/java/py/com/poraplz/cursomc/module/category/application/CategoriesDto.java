package py.com.poraplz.cursomc.module.category.application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDto {
    @JsonIgnore
    private Long id;
    @NotEmpty(message = "0031") @Size(min = 5, max = 80, message = "0032")
    private String name;
    @JsonIgnore
    public List<ProductEntity> products = new ArrayList<>();


    public CategoriesDto() {
    }

    public CategoriesDto(CategoryEntity categoryEntity){
        this.id = categoryEntity.getId();
        this.name = categoryEntity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
