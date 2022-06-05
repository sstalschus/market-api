package com.market.api.service;

import com.market.api.domain.Customer;
import com.market.api.exception.NotFoundException;
import com.market.api.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Customer service.
 */
@Service
public class CustomerService {

  private final CustomerRepository repository;

  private final BrandService brandService;

  /**
   * Instantiates a new Customer service.
   *
   * @param repository   the repository
   * @param brandService the brand service
   */
  @Autowired
  public CustomerService(final CustomerRepository repository, final BrandService brandService) {
    this.repository = repository;
    this.brandService = brandService;
  }

  /**
   * Create customer.
   *
   * @param customer the customer
   * @return the customer
   */
  public Customer create(Customer customer) {
    return repository.save(customer);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Customer> getAll() {
    return repository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  public Customer getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException("Supplier not founded by id: " + id));
  }

  public Customer getByEmail(String email) {
    return repository.findByEmail(email);
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
   * Update customer.
   *
   * @param customer the customer
   * @return the customer
   */
  public Customer update(Customer customer) {
    validateIfExists(customer.getId());
    return repository.save(customer);
  }

  private void validateIfExists(Long id) {
    getById(id);
  }

}
