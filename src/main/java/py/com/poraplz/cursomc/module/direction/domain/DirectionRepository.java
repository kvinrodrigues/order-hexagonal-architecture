package py.com.poraplz.cursomc.module.direction.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.poraplz.cursomc.module.direction.infraestructure.db.jpa.DirectionEntity;

public interface DirectionRepository extends JpaRepository<DirectionEntity, Long>{

}
