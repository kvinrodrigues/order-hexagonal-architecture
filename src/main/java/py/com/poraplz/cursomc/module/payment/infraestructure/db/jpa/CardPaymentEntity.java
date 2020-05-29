package py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
import py.com.poraplz.cursomc.module.payment.domain.PaymentState;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card_payment")
@JsonTypeName("CardPayment")
@EqualsAndHashCode(callSuper = true)
@Data
public class CardPaymentEntity extends PaymentEntity {

    private Integer plotsNumber;

    public CardPaymentEntity() { }

    public CardPaymentEntity(PaymentState estado, OrderEntity orderEntity, DirectionEntity directionEntity, Integer plotsNumber) {
        super(estado, orderEntity, directionEntity);
        this.plotsNumber = plotsNumber;
    }
}
