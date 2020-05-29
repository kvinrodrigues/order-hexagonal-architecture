package py.com.poraplz.cursomc.services;

import org.springframework.mail.SimpleMailMessage;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;
import py.com.poraplz.cursomc.module.order.infraestructure.db.jpa.OrderEntity;

public interface EmailService {
    void sendOrderConfirmation(OrderEntity order);
    void sendEmail(SimpleMailMessage msg);
    void sendChangeOfPassword(String token);
    void sendNewPasswordEmail(ClientEntity clientEntity, String newPass);
}
