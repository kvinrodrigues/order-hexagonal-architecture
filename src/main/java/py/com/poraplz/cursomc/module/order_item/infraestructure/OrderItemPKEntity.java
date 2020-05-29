package py.com.poraplz.cursomc.module.order_item.infraestructure;

import lombok.Data;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class OrderItemPKEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name= "product_id")
    private ProductEntity product;
}
