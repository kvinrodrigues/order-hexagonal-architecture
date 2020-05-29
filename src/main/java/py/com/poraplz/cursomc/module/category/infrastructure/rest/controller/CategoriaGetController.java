package py.com.poraplz.cursomc.module.category.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import py.com.poraplz.cursomc.module.category.application.CategoryResponse;
import py.com.poraplz.cursomc.module.category.application.find.CategoryFinder;

import java.util.List;

@RestController
public class CategoriaGetController {
    private final CategoryFinder finder;

    public CategoriaGetController(CategoryFinder finder) {
        this.finder = finder;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok().body(finder.getAllCategories());
    }

    @RequestMapping(value = "category/{id}", method = RequestMethod.GET )
    public ResponseEntity<?> findCategoryById(@PathVariable Long id){
        CategoryResponse categoryEntity = finder.find(id);
        return ResponseEntity.ok().body(categoryEntity);
    }
}
