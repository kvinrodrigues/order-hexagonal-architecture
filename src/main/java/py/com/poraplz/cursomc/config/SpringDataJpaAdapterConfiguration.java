package py.com.poraplz.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategorySpringJpaAdapter;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategorySpringJpaRepository;

@Configuration
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public CategoryRepository getCategoryPort(CategorySpringJpaRepository categoryRepository) {
        return new CategorySpringJpaAdapter(categoryRepository);
    }

}
