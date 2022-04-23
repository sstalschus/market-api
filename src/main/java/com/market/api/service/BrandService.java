package com.market.api.service;

import com.market.api.domain.Brand;
import com.market.api.repository.BrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

  private final BrandRepository repository;

  @Autowired
  public BrandService(BrandRepository repository) {
    this.repository = repository;
  }

  public Brand create(Brand brand) {
    if (brandAlreadyExists(brand))
      return repository.findByName(brand.getName()
          .toUpperCase());
    brand.setName(brand.getName()
        .toUpperCase());
    return repository.save(brand);
  }

  public List<Brand> getAll() {
    return repository.findAll();
  }

  private boolean brandAlreadyExists(Brand brand) {
    return repository.findByName(brand.getName()
        .toUpperCase()) != null;
  }

}
