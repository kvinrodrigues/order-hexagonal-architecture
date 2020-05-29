package py.com.poraplz.cursomc.module.estate.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.poraplz.cursomc.module.estate.infraestructure.db.jpa.EstateEntity;

@Repository
public interface EstateRepository extends JpaRepository<EstateEntity, Long>{

    public EstateEntity getById(Long id);

}
