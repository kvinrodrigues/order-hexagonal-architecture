package py.com.poraplz.cursomc.dto.order;

import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;
import py.com.poraplz.cursomc.module.order_item.infraestructure.OrderItemEntity;
import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.PaymentEntity;

import java.util.HashSet;
import java.util.Set;

public class OrderDto {

    private PaymentEntity pay;
    private DirectionEntity adress;
    private ClientEntity clientEntity;
    private Set<OrderItemEntity> items = new HashSet();
    public PaymentEntity getPay() {
        return pay;
    }

    public DirectionEntity getAdress() {
        return adress;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public Set<OrderItemEntity> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "pay=" + pay +
                ", adress=" + adress +
                ", clientEntity=" + clientEntity +
                ", items=" + items +
                '}';
    }
}
