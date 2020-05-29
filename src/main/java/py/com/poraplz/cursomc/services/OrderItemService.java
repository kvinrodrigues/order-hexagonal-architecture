package py.com.poraplz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.order_item.infraestructure.OrderItemEntity;
import py.com.poraplz.cursomc.module.order_item.domain.OrderItemRepository;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    public OrderItemEntity saveOrUpdate(OrderItemEntity orderItemEntity){
        return repository.save(orderItemEntity);
    }

}
