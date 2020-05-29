//package py.com.poraplz.cursomc.rest.controllers.order;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
//import py.com.poraplz.cursomc.services.OrderService;
//
//@Controller
//public class OrderGetController {
//    OrderService service;
//
//    public OrderGetController(OrderService service) {
//        this.service = service;
//    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping(value = "order/{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> find(@PathVariable Long id) {
//        OrderEntity orderEntity = service.findOrder(id);
//        return ResponseEntity.ok(orderEntity);
//    }
//}
