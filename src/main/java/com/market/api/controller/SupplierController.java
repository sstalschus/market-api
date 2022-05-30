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

/**
 * The type Supplier controller.
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

  private final SupplierService service;

  /**
   * Instantiates a new Supplier controller.
   *
   * @param service the service
   */
  public SupplierController(final SupplierService service) {
    this.service = service;
  }

  /**
   * Create response entity.
   *
   * @param supplier the supplier
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity create(@RequestBody Supplier supplier) {
    service.create(supplier);
    return ResponseEntity.status(HttpStatus.CREATED)
        .build();
  }

  /**
   * Update response entity.
   *
   * @param supplier the supplier
   * @return the response entity
   */
  @PatchMapping
  public ResponseEntity update(@RequestBody Supplier supplier) {
    service.update(supplier);
    return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
        .build();
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  @GetMapping
  public ResponseEntity getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  @GetMapping("/{id}")
  public ResponseEntity getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getById(id));
  }

  /**
   * Delete by id response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping("/{id}")
  public ResponseEntity deleteById(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .build();
  }

}
