package py.com.poraplz.cursomc.module.order_item.infraestructure;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Table(name = "order_item")
@Data
public class OrderItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @EmbeddedId
    OrderItemPKEntity id = new OrderItemPKEntity();
    private Double discount;
    private Integer quantity;
    private Double price;

    public OrderItemEntity() {
    }

    public OrderItemEntity(ProductEntity productEntity, OrderEntity orderEntity, Double discount, Integer quantity, Double price) {
        id.setProduct(productEntity);
        id.setOrder(orderEntity);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public Double getSubtTotal() {
        return (price - discount) * quantity;

    }

    public ProductEntity getProducto() {
        return this.id.getProduct();
    }

    @JsonIgnore
    public OrderEntity getPedido() {
        return this.id.getOrder();
    }

    public void setOrder(OrderEntity order) {
        id.setOrder(order);
    }

    public void setProduct(ProductEntity productEntity) {
        this.id.setProduct(productEntity);
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("es", "PY"));
        final StringBuilder sb = new StringBuilder("OrderItemEntity{");
        sb.append(getProducto().getName());
        sb.append(", Cantidad: ").append(getQuantity());
        sb.append(", Precio unitario:").append(numberFormat.format(getPrice()));
        sb.append(", SubTotal: ").append(numberFormat.format(getSubtTotal()));
        sb.append('}').append("\n");
        return sb.toString();
    }
}
