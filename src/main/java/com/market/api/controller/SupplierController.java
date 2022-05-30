package com.market.api.controller;

import com.market.api.domain.Supplier;
import com.market.api.service.SupplierService;
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
@RequestMapping("/supplier")
public class SupplierController {

  private final SupplierService service;

  public SupplierController(final SupplierService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody Supplier supplier) {
    service.create(supplier);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PatchMapping
  public ResponseEntity update(@RequestBody Supplier supplier) {
    service.update(supplier);
    return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
  }

  @GetMapping
  public ResponseEntity getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteById(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
