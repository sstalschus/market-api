package com.market.api.service;

import com.market.api.domain.Brand;
import com.market.api.domain.Product;
import com.market.api.exception.AlreadyExistsException;
import com.market.api.exception.NotFoundException;
import com.market.api.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Product service.
 */
@Service
public class ProductService {

  private final ProductRepository repository;

  private final BrandService brandService;

  /**
   * Instantiates a new Product service.
   *
   * @param repository   the repository
   * @param brandService the brand service
   */
  @Autowired
  public ProductService(final ProductRepository repository, BrandService brandService) {
    this.repository = repository;
    this.brandService = brandService;
  }

  /**
   * Create product.
   *
   * @param product the product
   * @return the product
   */
  public Product create(Product product) {
    if (productAlreadyExists(product)) throw new AlreadyExistsException("Product already exists");
    Brand brand = brandService.create(product.getBrand());
    product.setBrand(brand);
    return repository.save(product);
  }

  /**
   * Find by id product.
   *
   * @param id the id
   * @return the product
   */
  public Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException("Product not found"));
  }

  /**
   * Update product.
   *
   * @param product the product
   * @return the product
   */
  public Product update(Product product) {
    findById(product.getId());
    return repository.save(product);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Product> getAll() {
    return repository.findAll();
  }

  /**
   * Delete by id.
   *
   * @param id the id
   */
  public void deleteById(Long id) {
    findById(id);
    repository.deleteById(id);
  }

  private boolean productAlreadyExists(Product product) {
    return repository.findByNameAndBrandName(product.getName(), product.getBrand()
        .getName()
        .toUpperCase()) != null;
  }

}
