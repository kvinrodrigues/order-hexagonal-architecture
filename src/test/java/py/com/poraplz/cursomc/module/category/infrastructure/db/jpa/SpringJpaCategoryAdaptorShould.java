package py.com.poraplz.cursomc.module.category.infrastructure.db.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import py.com.poraplz.cursomc.module.category.CategoryModuleInfrastructureTestCase;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryMother;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class SpringJpaCategoryAdaptorShould extends CategoryModuleInfrastructureTestCase {

    @Test
    void save_a_category() {
        Category category = CategoryMother.random();

        mySpringJpaRepository.save(category);
    }

    @Test
    void find_using_an_id() {
        Category category = CategoryMother.random();
        Category savedCategory = mySpringJpaRepository.save(category);

        Optional<Category> byId = mySpringJpaRepository.findById(savedCategory.id().value());
        assertTrue(byId.isPresent());
    }

    @Test
    void search_all_existing_categories() {
        Category category = CategoryMother.random();
        Category anotherCategory = CategoryMother.random();

        Category savedCategory = mySpringJpaRepository.save(category);
        Category anotherSavedCategory = mySpringJpaRepository.save(anotherCategory);

        List<Category> categories = mySpringJpaRepository.getAll();

        assertTrue(categories.containsAll(Arrays.asList(savedCategory, anotherSavedCategory)));

    }
}
