package com.market.api.repository;

import com.market.api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(value = "Select p from Product p where p.name = :name and p.brand.name = :brand")
  Product findByNameAndBrandName(String name, String brand);

}
