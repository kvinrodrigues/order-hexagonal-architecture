package py.com.poraplz.cursomc.module.city.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.poraplz.cursomc.module.city.infrastructure.db.jpa.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long>{

    public CityEntity getById(Long id);
}
