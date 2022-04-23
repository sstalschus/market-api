package com.market.api.controller.service;

import com.market.api.domain.Product;
import com.market.api.exception.NotFoundException;
import com.market.api.exception.ProductAlreadyExistsException;
import com.market.api.exception.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        if(productAlreadyExists(product)) throw new ProductAlreadyExistsException("Product already exists");
        return repository.save(product);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public Product update(Product product) {
        findById(product.getId());
        return repository.save(product);
    }

    public Page<Product> getAll(final int page, final int size) {
        Pageable firstPageWithTwoElements = PageRequest.of(page, size);
        return repository.findAll(firstPageWithTwoElements);
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private boolean productAlreadyExists(Product product) {
        return repository.findByNameAndBrand(product.getName(), product.getBrand()) != null ? true : false;
    }
}
