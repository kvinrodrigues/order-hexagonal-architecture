package py.com.poraplz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;
import py.com.poraplz.cursomc.security.JWTUtil;

import java.util.Date;

@Service
public abstract class AbstractEmailService implements EmailService{
    @Value("${default.sender}")
    private String fromEmail;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private ClientService clienteService;


    @Override
    public void sendOrderConfirmation(OrderEntity order){
        SimpleMailMessage sm = prepareSimpleMailMessageFromOrder(order);
        sendEmail(sm);
    }

    //TODO Mejorar mensaje a enviar
    @Override
    public void sendChangeOfPassword(String token){
        String username = jwtUtil.getUserName(token);
        ClientEntity clientEntity = clienteService.getByEmail(username);
        SimpleMailMessage mailMessage = prepareSimpleMailMessageFromCliente(clientEntity);
        sendEmail(mailMessage);
    }

    @Override
    public void sendNewPasswordEmail(ClientEntity clientEntity, String newPass){
        SimpleMailMessage sm = prepareNewPasswordEmail(clientEntity, newPass);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromOrder(OrderEntity order){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setFrom(fromEmail);
        sm.setTo(order.getClient().getEmail());
        sm.setSubject("OrderEntity confirmado! Codigo: "+ order.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(order.toString());
        return sm;

    }

    protected SimpleMailMessage prepareSimpleMailMessageFromCliente(ClientEntity value){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setFrom(fromEmail);
        sm.setTo(value.getEmail());
        sm.setSubject("token");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("token: " + value.getForgotPassToken());
        return sm;

    }

    protected SimpleMailMessage prepareNewPasswordEmail(ClientEntity clientEntity, String pass){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setFrom(fromEmail);
        sm.setTo(clientEntity.getEmail());
        sm.setSubject("OrderEntity de cambio de password");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nuevo password: "+ pass);
        return sm;
    }



}
