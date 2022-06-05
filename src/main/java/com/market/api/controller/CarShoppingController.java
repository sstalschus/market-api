package com.market.api.controller;

import com.market.api.controller.dto.CarShoppingDTO;
import com.market.api.service.CarShoppingService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Car shopping controller.
 */
@RestController
@RequestMapping("/car-shopping")
public class CarShoppingController {

  private final CarShoppingService service;

  /**
   * Instantiates a new Car shopping controller.
   *
   * @param service the service
   */
  public CarShoppingController(final CarShoppingService service) {
    this.service = service;
  }

  /**
   * Create response entity.
   *
   * @param carShopping the car shopping
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<CarShoppingDTO> create(@Valid @RequestBody CarShoppingDTO carShopping) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(CarShoppingDTO.convert(service.create(CarShoppingDTO.convert(carShopping))));
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  @GetMapping
  public ResponseEntity<List<CarShoppingDTO>> getAll() {
    return ResponseEntity.ok(service.getAll()
        .stream()
        .map(CarShoppingDTO::convert)
        .collect(Collectors.toList()));
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<CarShoppingDTO> getById(@PathVariable Long id) {
    return ResponseEntity.ok(CarShoppingDTO.convert(service.getById(id)));
  }

  /**
   * Update response entity.
   *
   * @param carShopping the car shopping
   * @return the response entity
   */
  @PutMapping
  public ResponseEntity update(@Valid @RequestBody CarShoppingDTO carShopping) {
    service.update(CarShoppingDTO.convert(carShopping));
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .build();
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
