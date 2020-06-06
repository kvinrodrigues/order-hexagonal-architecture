package py.com.poraplz.cursomc.module.category.application.update;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryMother;
import py.com.poraplz.cursomc.module.category.domain.CategoryName;
import py.com.poraplz.cursomc.module.category.domain.CategoryNameMother;
import py.com.poraplz.cursomc.module.category.CategoryModuleUnitTestCase;
import py.com.poraplz.cursomc.module.shared.domain.exceptions.ObjectNotFound;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRenamerShould extends CategoryModuleUnitTestCase {
    CategoryRenamer renamer;

    @BeforeEach
    public void setUp() {
        super.setUp();
        renamer = new CategoryRenamer(repository);
    }

    @Test
    public void itShouldModifyAnExistingCategory() {
        Category existingCategory = CategoryMother.random();
        CategoryName newName = CategoryNameMother.random();
        shouldRename(existingCategory);

        Category renamedCategory = renamer.rename(existingCategory.id().value(), newName);

        assertEquals(existingCategory.id(), renamedCategory.id());
    }

    @Test
    public void itShouldThrowObjectNotFoundWhenRenameANonExistingCategory() {
        assertThrows(ObjectNotFound.class, () -> {
            Category existingCategory = CategoryMother.random();
            CategoryName newName = CategoryNameMother.random();
            renamer.rename(existingCategory.id().value(), newName);
        });
    }

}
