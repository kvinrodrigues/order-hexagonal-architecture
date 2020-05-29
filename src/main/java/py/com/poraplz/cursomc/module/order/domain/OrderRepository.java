package py.com.poraplz.cursomc.module.order.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Transactional(readOnly = true)
    Page<OrderEntity> findByClient(ClientEntity clientEntity, Pageable pageRequest);

}
