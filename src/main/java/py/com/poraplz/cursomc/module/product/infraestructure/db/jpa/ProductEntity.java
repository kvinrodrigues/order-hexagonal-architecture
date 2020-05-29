package py.com.poraplz.cursomc.module.product.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.module.order_item.infraestructure.OrderItemEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @ManyToMany
    @JoinTable(name= "product_category",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false))
    private List<CategoryEntity> categories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemEntity> items = new HashSet();

    public ProductEntity() { }

    public ProductEntity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
