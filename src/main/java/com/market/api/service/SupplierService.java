package com.market.api.service;

import com.market.api.domain.Supplier;
import com.market.api.exception.NotFoundException;
import com.market.api.repository.SupplierRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Supplier service.
 */
@Service
public class SupplierService {

  private final SupplierRepository repository;

  /**
   * Instantiates a new Supplier service.
   *
   * @param repository the repository
   */
  @Autowired
  public SupplierService(final SupplierRepository repository) {
    this.repository = repository;
  }

  /**
   * Create supplier.
   *
   * @param supplier the supplier
   * @return the supplier
   */
  public Supplier create(Supplier supplier) {
    return repository.save(supplier);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Supplier> getAll() {
    return repository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  public Supplier getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Supplier not founded by id: " + id));
  }

  /**
   * Delete by id.
   *
   * @param id the id
   */
  public void deleteById(Long id) {
    validateIfExists(id);
    repository.deleteById(id);
  }

  /**
   * Update supplier.
   *
   * @param supplier the supplier
   * @return the supplier
   */
  public Supplier update(Supplier supplier) {
    validateIfExists(supplier.getId());
    return repository.save(supplier);
  }

  private void validateIfExists(Long id) {
    getById(id);
  }
}
