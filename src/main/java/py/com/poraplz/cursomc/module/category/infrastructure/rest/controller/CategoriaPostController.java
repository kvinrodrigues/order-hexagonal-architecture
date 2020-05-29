package py.com.poraplz.cursomc.module.category.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import py.com.poraplz.cursomc.module.category.application.CategoriesDto;
import py.com.poraplz.cursomc.module.category.infrastructure.db.jpa.CategoryEntity;
import py.com.poraplz.cursomc.services.CategoryService;

import javax.validation.Valid;
import java.net.URI;

@Controller
public class CategoriaPostController {
//    private CategoryService service;
//
//    public CategoriaPostController(CategoryService service) {
//        this.service = service;
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/category")
//    public ResponseEntity<Void> save(@Valid @RequestBody CategoriesDto request) {
//        CategoryEntity categoryEntity = service.saveOrUpdate(service.fromDtoToCategory(request));
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(categoryEntity.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//
//    }
}
