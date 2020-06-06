package py.com.poraplz.cursomc.module.category.application.add;

import org.junit.jupiter.api.Test;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryMother;
import py.com.poraplz.cursomc.module.category.CategoryModuleUnitTestCase;

import static org.junit.jupiter.api.Assertions.*;

class CategorySaverShould extends CategoryModuleUnitTestCase {
    @Test
    public void ItShouldSaveACategory () {
        CategorySaver saver = new CategorySaver(repository);
        Category category = CategoryMother.random();

        shouldSave(category);
        Category savedCategory = saver.save(category);

        assertEquals(category, savedCategory);
    }

}
