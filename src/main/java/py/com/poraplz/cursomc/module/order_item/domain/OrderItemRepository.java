package py.com.poraplz.cursomc.module.order_item.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.poraplz.cursomc.module.order_item.infraestructure.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {


}
