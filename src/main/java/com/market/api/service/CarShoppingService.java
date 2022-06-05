package com.market.api.service;

import com.market.api.domain.CarShopping;
import com.market.api.domain.Customer;
import com.market.api.domain.Product;
import com.market.api.exception.NotFoundException;
import com.market.api.repository.CarShoppingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Car shopping service.
 */
@Service
public class CarShoppingService {

  private final CarShoppingRepository repository;

  private final CustomerService customerService;

  private final ProductService productService;

  /**
   * Instantiates a new Car shopping service.
   *
   * @param repository      the repository
   * @param customerService the customer service
   * @param productService  the product service
   */
  @Autowired
  public CarShoppingService(final CarShoppingRepository repository,
                            final CustomerService customerService,
                            final ProductService productService) {
    this.repository = repository;
    this.customerService = customerService;
    this.productService = productService;
  }

  /**
   * Create car shopping.
   *
   * @param carShopping the car shopping
   * @return the car shopping
   */
  public CarShopping create(CarShopping carShopping) {

    List<Product> productList = new ArrayList<>();

    Customer customer = customerService.getByEmail(carShopping.getCustomer()
        .getEmail());

    if(customer == null)
      carShopping.setCustomer(customerService.create(carShopping.getCustomer()));
    else
      carShopping.setCustomer(customer);


    carShopping.getProducts().forEach(productInCart -> {
      productList.add(productService.findById(productInCart.getId()));
    });


    return repository.save(carShopping);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<CarShopping> getAll() {
    return repository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  public CarShopping getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException("Car shopping not found"));
  }

  /**
   * Update car shopping.
   *
   * @param carShopping the car shopping
   * @return the car shopping
   */
  public CarShopping update(CarShopping carShopping) {
    assertOfExists(carShopping.getId());
    return repository.save(carShopping);
  }

  /**
   * Delete by id.
   *
   * @param id the id
   */
  public void deleteById(Long id) {
    assertOfExists(id);
    repository.deleteById(id);
  }

  /**
   * Assert of exists.
   *
   * @param id the id
   */
  public void assertOfExists(Long id) {
    getById(id);
  }

}
