package py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
import py.com.poraplz.cursomc.module.payment.domain.PaymentState;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ticket_payment")
@JsonTypeName("TicketPayment")
@EqualsAndHashCode(callSuper = true)
@Data
public class TicketPaymentEntity extends PaymentEntity {

    private Date expirationData;
    private Date payData;

    public TicketPaymentEntity() {
    }

    public TicketPaymentEntity(PaymentState estado, OrderEntity orderEntity, DirectionEntity directionEntity, Date expirationData, Date payData) {
        super(estado, orderEntity, directionEntity);
        this.expirationData = expirationData;
        this.payData = payData;
    }
}
