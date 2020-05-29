package py.com.poraplz.cursomc.module.client.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import py.com.poraplz.cursomc.module.client.infraestructure.db.jpa.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
     ClientEntity getById(Long id);
     @Transactional(readOnly = true)
     ClientEntity getByEmail(String email);

}
