package py.com.poraplz.cursomc.module.category.infrastructure.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorySpringJpaRepository extends JpaRepository<CategoryEntity, Long> {

}
