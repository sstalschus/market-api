package com.market.api.repository;

import com.market.api.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  /**
   * Find by name and brand name product.
   *
   * @param name  the name
   * @param brand the brand
   * @return the product
   */
  @Query(value = "Select p from Product p where p.name = :name and p.brand.name = :brand")
  Product findByNameAndBrandName(String name, String brand);

  @Query(value = "Select p from Product p where p.name LIKE %:name%")
  List<Product> findByNameContains(String name);

}
