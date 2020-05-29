package py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
import py.com.poraplz.cursomc.module.payment.domain.PaymentState;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@Data
public abstract class PaymentEntity implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer payState;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private DirectionEntity address;

    public PaymentEntity() {
    }

    public PaymentEntity(PaymentState payState, OrderEntity order, DirectionEntity address) {
        this.payState = (payState == null) ? null: payState.getValue();
        this.order = order;
        this.address = address;
    }

    public PaymentState getEstado() {
        return PaymentState.toEnum(this.payState);
    }

    public void setEstado(PaymentState state) {
        this.payState= state.getValue();
    }

}
