//package py.com.poraplz.cursomc.services;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import py.com.poraplz.cursomc.dto.order.OrderDto;
//import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
//import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.TicketPaymentEntity;
//import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;
//import py.com.poraplz.cursomc.rest.controllers.auth.AuthorizationException;
//import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;
//import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
//import py.com.poraplz.cursomc.module.order_item.infraestructure.OrderItemEntity;
//import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.CardPaymentEntity;
//import py.com.poraplz.cursomc.module.order.domain.OrderRepository;
//import py.com.poraplz.cursomc.security.User;
//
//import java.util.Optional;
//
//@Service
//public class OrderService {
//
//    private OrderRepository dao;
//    private Ticket ticket;
//    private PaymentService paymentService;
//    private ProductService productService;
//    private OrderItemService orderItemService;
//    private ClientService clienteService;
//    private EmailService emailService;
//
//    public OrderService(OrderRepository repo, Ticket ticket, PaymentService paymentService,
//                        ProductService productService, OrderItemService orderItemService,
//                        ClientService clienteService, EmailService emailService){
//        this.dao = repo;
//        this.ticket = ticket;
//        this.paymentService = paymentService;
//        this.productService = productService;
//        this.orderItemService = orderItemService;
//        this.clienteService = clienteService;
//        this.emailService = emailService;
//    }
//
//    public OrderEntity findOrder(Long id){
//        Optional<OrderEntity> obj = dao.findById(id);
//        return obj.orElseThrow(() -> new ObjectNotFound("No se encontro pedido "+
//                ", Tipo: " + OrderEntity.class.getName()));
//    }
//
//    public Page<OrderEntity> ByClient(Integer page, Integer linesPerPage, String column
//            , String direction){
//        User user = UserService.getLoggedUser();
//        if(user == null) {
//            throw new AuthorizationException("Acceso denegado");
//        }
//        ClientEntity clientEntity = clienteService.getClient(user.getId());
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage,
//                Sort.Direction.valueOf(direction), column);
//        return dao.findByClient(clientEntity, pageRequest);
//
//    }
//
//    public OrderEntity saveOrUpdate(OrderEntity order){
//        if(order.getPayment() instanceof TicketPaymentEntity){
//            TicketPaymentEntity pagoConBoleto = (TicketPaymentEntity) order.getPayment();
//            ticket.processBoletoPayment(pagoConBoleto, order.getMoment());
//        }else if(order.getPayment() instanceof CardPaymentEntity){
//            CardPaymentEntity pagoConTarjeta = (CardPaymentEntity) order.getPayment();
//
//        }
//        ClientEntity clientEntity = clienteService.getClient(order.getClient().getId());
//        order.setClient(clientEntity);
//        order = dao.save(order);
//        paymentService.saveOrUpdate(order.getPayment());
//
//        for(OrderItemEntity item: order.getItems()){
//            item.setDiscount(0.0D);
//            ProductEntity productEntity = productService.findById(item.getProducto().getId());
//            item.setProduct(productEntity);
//            item.setPrice(productEntity.getPrice());
//            item.setOrder(order);
//
//            orderItemService.saveOrUpdate(item);
//        }
//        emailService.sendOrderConfirmation(order);
//        return order;
//    }
//
//    public OrderEntity fromDtoToOrder(OrderDto dto){
//
//        return new OrderEntity(dto);
//    }
//}
