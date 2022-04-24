package com.market.api.controller;

import com.market.api.controller.dto.BrandDTO;
import com.market.api.service.BrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Brand controller.
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

  private final BrandService service;

  /**
   * Instantiates a new Brand controller.
   *
   * @param service the service
   */
  @Autowired
  public BrandController(BrandService service) {
    this.service = service;
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  @GetMapping
  public ResponseEntity<List<BrandDTO>> getAll() {
    return ResponseEntity.ok(
        service.getAll()
            .stream()
            .map(BrandDTO::convert)
            .collect(Collectors.toList())
    );
  }

}
