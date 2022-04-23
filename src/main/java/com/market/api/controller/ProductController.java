package com.market.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.api.domain.Product;
import com.market.api.domain.dto.ProductDTO;
import com.market.api.controller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    public static final int SIZE_PER_PAGE = 20;
    private final ProductService service;

    private final ObjectMapper objectMapper;

    @Autowired
    public ProductController(final ProductService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody final ProductDTO productDTO) {
        Product product = ProductDTO.convert(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductDTO.convert(service.create(product)));
    }

    @PatchMapping
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody final ProductDTO productDTO) {
        Product product = ProductDTO.convert(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductDTO.convert(service.update(product)));
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@Nullable @RequestParam Integer page) {
        if(page == null) page = 0;
        return ResponseEntity.ok(
                service.getAll(page, SIZE_PER_PAGE)
        );
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
