package py.com.poraplz.cursomc.module.category.infrastructure.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.poraplz.cursomc.module.category.application.CategoryResponse;
import py.com.poraplz.cursomc.module.category.application.update.CategoryRenamer;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.domain.CategoryName;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryPutController {
    private final CategoryRenamer updater;

    public CategoryPutController(CategoryRenamer updater) {
        this.updater = updater;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> rename(@Valid @RequestBody String name, @PathVariable Long id) {
        Category updatedCategory = updater.rename(id, new CategoryName(name));
        CategoryResponse response = CategoryResponse.fromAggregate(updatedCategory);
        return ResponseEntity.ok().body(response);
    }
}
