//package py.com.poraplz.cursomc.rest.controllers.order;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import py.com.poraplz.cursomc.dto.order.OrderDto;
//import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
//import py.com.poraplz.cursomc.services.OrderService;
//
//import javax.validation.Valid;
//import java.net.URI;
//
//@Controller
//public class OrderPostController {
//    OrderService service;
//
//    public OrderPostController(OrderService service) {
//        this.service = service;
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> save(@Valid @RequestBody OrderDto request) {
//        OrderEntity order = service.saveOrUpdate(service.fromDtoToOrder(request));
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(order.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//    }
//}
