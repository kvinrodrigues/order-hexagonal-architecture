package py.com.poraplz.cursomc.dto.products;

import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;

public class ProductsDto {
    private Long id;
    private String name;
    private double price;

    public ProductsDto(ProductEntity productEntity){
        this.name = productEntity.getName();
        this.price = productEntity.getPrice();
        this.id = productEntity.getId();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
