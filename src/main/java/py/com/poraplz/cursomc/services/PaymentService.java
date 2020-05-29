package py.com.poraplz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.PaymentEntity;
import py.com.poraplz.cursomc.module.payment.domain.PaymentRepository;

@Service
public class PaymentService {

   @Autowired
    private PaymentRepository repository;

   public PaymentEntity saveOrUpdate(PaymentEntity paymentEntity){
       return repository.save(paymentEntity);

   }
}
