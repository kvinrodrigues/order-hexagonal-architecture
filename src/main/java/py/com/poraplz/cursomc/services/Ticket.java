package py.com.poraplz.cursomc.services;

import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.TicketPaymentEntity;

import java.util.Calendar;
import java.util.Date;

@Service
public class Ticket {

    public void processBoletoPayment(TicketPaymentEntity paymentInstance, Date startDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        paymentInstance.setExpirationData(calendar.getTime());
    }
}
