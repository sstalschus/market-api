package com.market.api.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.api.domain.Product;
import com.market.api.domain.dto.ProductDTO;
import com.market.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    private final ObjectMapper objectMapper;

    @Autowired
    public ProductController(final ProductService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        Product product = ProductDTO.convert(productDTO);
        return ResponseEntity.ok(ProductDTO.convert(service.create(product)));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(service.getAll().stream().map(ProductDTO::convert).collect(Collectors.toList()));
    }

}
