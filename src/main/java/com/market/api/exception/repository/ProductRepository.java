package com.market.api.exception.repository;

import com.market.api.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Product findByNameAndBrand(String name, String brand);
}
