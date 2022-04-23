package com.market.api.controller;

import com.market.api.controller.dto.ProductDTO;
import com.market.api.domain.Product;
import com.market.api.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  public static final int SIZE_PER_PAGE = 20;

  private final ProductService service;

  @Autowired
  public ProductController(final ProductService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<ProductDTO> create(@Valid @RequestBody final ProductDTO productDTO) {
    Product product = ProductDTO.convert(productDTO);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ProductDTO.convert(service.create(product)));
  }

  @PatchMapping
  public ResponseEntity<ProductDTO> update(@Valid @RequestBody final ProductDTO productDTO) {
    Product product = ProductDTO.convert(productDTO);
    return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
        .body(ProductDTO.convert(service.update(product)));
  }

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAll() {
    return ResponseEntity.ok(
        service.getAll()
            .stream()
            .map(ProductDTO::convert)
            .collect(Collectors.toList())
    );
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity deleteById(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.ok()
        .build();
  }

}
