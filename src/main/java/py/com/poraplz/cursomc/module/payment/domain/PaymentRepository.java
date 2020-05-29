package py.com.poraplz.cursomc.module.payment.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.poraplz.cursomc.module.payment.infraestructure.db.jpa.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{


}
