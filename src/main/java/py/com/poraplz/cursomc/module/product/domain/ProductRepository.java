package py.com.poraplz.cursomc.module.product.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
   @Transactional(readOnly = true)
   @Query("SELECT DISTINCT obj from ProductEntity obj INNER  JOIN obj.categories cat where obj.name LIKE %:name% AND cat IN :categories")
   Page<ProductEntity> findDistinctByNameContainingAndCategoriesIn(@Param("name") String name, @Param("categories") List<CategoryEntity> categories, Pageable pageRequest);


}
