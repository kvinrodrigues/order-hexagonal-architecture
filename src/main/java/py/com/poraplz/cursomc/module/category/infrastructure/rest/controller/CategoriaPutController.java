package py.com.poraplz.cursomc.module.category.infrastructure.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import py.com.poraplz.cursomc.module.category.application.CategoriesDto;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.services.CategoryService;

import javax.validation.Valid;

@Controller
public class CategoriaPutController {
//    private CategoryService service;
//
//    public CategoriaPutController(CategoryService service) {
//        this.service = service;
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CategoryEntity> update(@Valid @RequestBody CategoriesDto request, @PathVariable Long id){
//        CategoryEntity resp = service.updateCategory(request, id);
//        return ResponseEntity.ok().body(resp);
//    }

}
