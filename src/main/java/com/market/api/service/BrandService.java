package com.market.api.service;

import com.market.api.domain.Brand;
import com.market.api.repository.BrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Brand service.
 */
@Service
public class BrandService {

  private final BrandRepository repository;

  /**
   * Instantiates a new Brand service.
   *
   * @param repository the repository
   */
  @Autowired
  public BrandService(BrandRepository repository) {
    this.repository = repository;
  }

  /**
   * Create brand.
   *
   * @param brand the brand
   * @return the brand
   */
  public Brand create(Brand brand) {
    if (brandAlreadyExists(brand))
      return repository.findByName(brand.getName()
          .toUpperCase());
    brand.setName(brand.getName()
        .toUpperCase());
    return repository.save(brand);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Brand> getAll() {
    return repository.findAll();
  }

  public Brand getByName(String name) {
    return repository.findByName(name);
  }

  private boolean brandAlreadyExists(Brand brand) {
    return repository.findByName(brand.getName()
        .toUpperCase()) != null;
  }

}
