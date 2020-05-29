package py.com.poraplz.cursomc.module.category.infrastructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    public List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
