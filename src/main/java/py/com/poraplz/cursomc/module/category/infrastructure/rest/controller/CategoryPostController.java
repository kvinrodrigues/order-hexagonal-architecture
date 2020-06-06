package py.com.poraplz.cursomc.module.category.infrastructure.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import py.com.poraplz.cursomc.module.category.application.add.CategorySaver;
import py.com.poraplz.cursomc.module.category.domain.Category;
import py.com.poraplz.cursomc.module.category.infrastructure.model.CategoryMapper;
import py.com.poraplz.cursomc.module.category.infrastructure.model.CategoryRequest;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/category")
public class CategoryPostController {
    private final CategorySaver saver;

    public CategoryPostController(CategorySaver saver) {
        this.saver = saver;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@Valid @RequestBody CategoryRequest request) {
        Category category = CategoryMapper.toEntityFrom(request);
        Category savedCategory = saver.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCategory.id())
                .toUri();
        return ResponseEntity.created(uri).build();

    }
}
