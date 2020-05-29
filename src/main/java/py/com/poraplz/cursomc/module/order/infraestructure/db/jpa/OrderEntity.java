package py.com.poraplz.cursomc.module.order.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.parameters.P;
import py.com.poraplz.cursomc.dto.order.OrderDto;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.order_item.infraestructure.OrderItemEntity;
import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.PaymentEntity;
import py.com.poraplz.cursomc.module.payment.domain.PaymentState;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "requisition")
@Data
public class OrderEntity implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date moment;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private DirectionEntity address;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItemEntity> items = new HashSet();

    public OrderEntity(){ }

    public OrderEntity(Date moment, PaymentEntity payment, DirectionEntity adress, ClientEntity client, Set<OrderItemEntity> items) {
        this.moment = moment;
        this.payment = payment;
        this.address = adress;
        this.client = client;
        this.items = items;
    }

    /**
     * Constructor para carga de valores para la insercion de pedidos
     * @param dto: OrderDto
     */
    public OrderEntity(OrderDto dto){
        this.payment = dto.getPay();
        this.moment = new Date();
        this.items = dto.getItems();
        this.address = dto.getAdress();
        this.client = dto.getClientEntity();
        if (this.getPayment() != null) { // TODO CORREGIR!
            this.getPayment().setAddress(address);
            this.getPayment().setEstado(PaymentState.PENDIENTE);
            this.getPayment().setOrder(this);
        }
    }

    public Double getTotalAmount(){
        Double sum = 0.0D;
        for(OrderItemEntity item:items){
            sum += item.getSubtTotal();
        }
        return sum;
    }

    @JsonIgnore
    public List<ProductEntity> getProducts(){
        List<ProductEntity> list = new ArrayList();
        for (OrderItemEntity x: items){
            list.add(x.getProducto());
        }
        return list;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("es","PY"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        final StringBuilder sb = new StringBuilder("OrderEntity{");
        sb.append("OrderEntity numero=").append(id);
        sb.append(", Instante: ").append(sdf.format(getMoment()));
        sb.append(", ClientEntity: ").append(getClient().getName());
        sb.append(", EstateEntity de PaymentEntity: ").append(getPayment().getEstado().getDescription());
        sb.append("\nDetalles:\n");
        for(OrderItemEntity ip : getItems()){
            sb.append(ip.toString());
        }
        sb.append("Valor total: ").append(nf.format(getTotalAmount()));

        sb.append('}');
        return sb.toString();
    }
}
