package py.com.poraplz.cursomc.module.category.application.find;

import org.junit.jupiter.api.Test;
import py.com.poraplz.cursomc.module.category.application.CategoryResponse;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryMother;
import py.com.poraplz.cursomc.module.category.CategoryModuleUnitTestCase;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFinderShould extends CategoryModuleUnitTestCase {

    @Test
    void ItShouldFindAnExistingCategory() {
        CategoryFinder finder = new CategoryFinder(repository);
        Category category = CategoryMother.random();
        shouldSearch(category.id().value(), category);

        CategoryResponse response = finder.find(category.id().value());

        CategoryResponse expectedResponse = CategoryResponse.fromAggregate(category);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void itShouldThrowCategoryNotFound() {
        CategoryFinder finder = new CategoryFinder(repository);
        Category category = CategoryMother.random();

        assertThrows(ObjectNotFound.class, () -> finder.find(category.id().value()));
    }
}
