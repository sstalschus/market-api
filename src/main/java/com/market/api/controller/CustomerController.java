package com.market.api.controller;

import com.market.api.controller.dto.CustomerDTO;
import com.market.api.service.CustomerService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

  private final CustomerService service;

  /**
   * Instantiates a new Customer controller.
   *
   * @param service the service
   */
  public CustomerController(final CustomerService service) {
    this.service = service;
  }

  /**
   * Create response entity.
   *
   * @param customer the customer
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customer) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(CustomerDTO.convert(
            service.create(CustomerDTO.convert(customer))
        ));
  }

  /**
   * Update response entity.
   *
   * @param customer the customer
   * @return the response entity
   */
  @PatchMapping
  public ResponseEntity update(@Valid @RequestBody CustomerDTO customer) {
    CustomerDTO.convert(
        service.update(CustomerDTO.convert(customer))
    );
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .build();
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  @GetMapping
  public ResponseEntity<List<CustomerDTO>> getAll() {
    return
        ResponseEntity.ok(
            service.getAll()
                .stream()
                .map(CustomerDTO::convert)
                .collect(Collectors.toList())
        );
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<CustomerDTO> getById(@PathVariable Long id) {
    return ResponseEntity.ok(
        CustomerDTO.convert(service.getById(id))
    );
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
