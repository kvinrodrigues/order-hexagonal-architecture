package py.com.poraplz.cursomc.module.category.infrastructure.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import py.com.poraplz.cursomc.module.category.application.CategoryResponse;
import py.com.poraplz.cursomc.module.category.application.find.CategoryFinder;

@Controller
public class CategoryGetController {
    private final CategoryFinder finder;

    public CategoryGetController(CategoryFinder finder) {
        this.finder = finder;
    }

    @RequestMapping(value = "category/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCategoryById(@PathVariable Long id){
        CategoryResponse categoryEntity = finder.find(id);
        return ResponseEntity.ok().body(categoryEntity);
    }
}
