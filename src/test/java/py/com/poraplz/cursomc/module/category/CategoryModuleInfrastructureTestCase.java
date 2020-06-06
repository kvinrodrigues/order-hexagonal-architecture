package py.com.poraplz.cursomc.module.category;

import org.springframework.beans.factory.annotation.Autowired;

import py.com.poraplz.cursomc.OrderManagementInfrastructureTestCase;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;


public abstract class CategoryModuleInfrastructureTestCase extends OrderManagementInfrastructureTestCase {
    @Autowired
    protected CategoryRepository mySpringJpaRepository;

}
