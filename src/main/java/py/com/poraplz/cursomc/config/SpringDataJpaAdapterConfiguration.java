package py.com.poraplz.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.poraplz.cursomc.module.category.domain.CategoryRepository;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.SpringJpaCategoryAdaptor;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.SpringJpaCategoryRepository;

@Configuration
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public CategoryRepository getCategoryPort(SpringJpaCategoryRepository categoryRepository) {
        return new SpringJpaCategoryAdaptor(categoryRepository);
    }

}
