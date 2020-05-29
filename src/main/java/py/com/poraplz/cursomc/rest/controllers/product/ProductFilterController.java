package py.com.poraplz.cursomc.rest.controllers.product;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import py.com.poraplz.cursomc.dto.products.ProductsDto;
import py.com.poraplz.cursomc.module.product.infraestructure.db.jpa.ProductEntity;
import py.com.poraplz.cursomc.services.ProductService;
import py.com.poraplz.cursomc.utils.URLUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ProductFilterController {
    private ProductService service;

    public ProductFilterController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ProductsDto>> categoryPage(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "categories", defaultValue = "") String ids,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String columnName) {

        List<Long> categoriesIds = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        Page<ProductEntity> products = service.search(URLUtils.decodeParam(name), categoriesIds, page, linesPerPage, columnName, direction);
        Page<ProductsDto> dto = products.map(ProductsDto::new);
        return ResponseEntity.ok().body(dto);

    }
}
