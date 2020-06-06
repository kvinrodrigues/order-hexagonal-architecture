package py.com.poraplz.cursomc.module.category;

import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mock;
import org.mockito.Mockito;

import py.com.poraplz.cursomc.module.category.domain.*;
import py.com.poraplz.cursomc.shared.infraestructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public abstract class CategoryModuleUnitTestCase extends UnitTestCase {
    @Mock
    protected CategoryRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(CategoryRepository.class);
    }

    public void shouldSearch(Long id, Category category) {
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(category));
    }

    public void shouldSave(Category category) {
        Mockito.when(repository.save(category)).thenReturn(category);
    }

    public void shouldRename(Category existingCategory) {
        shouldSearch(existingCategory.id().value(), existingCategory);
        Mockito.when(repository.save(any())).then(i -> i.getArgument(0));
    }

}
