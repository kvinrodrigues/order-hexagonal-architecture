//package py.com.poraplz.cursomc.rest.controllers.order;
//
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
//import py.com.poraplz.cursomc.services.OrderService;
//
//public final class OrderFilterController {
//    OrderService service;
//
//    public OrderFilterController(OrderService service){
//        this.service = service;
//    }
//
//    @RequestMapping(value = "order/filter",method = RequestMethod.GET)
//    public ResponseEntity<Page<OrderEntity>> findPage(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
//            @RequestParam(value = "direction", defaultValue = "DESC") String direction,
//            @RequestParam(value = "orderBy", defaultValue = "id") String columnName){
//        Page<OrderEntity> orders = service.ByClient(page, linesPerPage,columnName , direction);
//
//        return ResponseEntity.ok().body(orders);
//    }
//}
