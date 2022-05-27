package com.market.api.repository;

import com.market.api.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Supplier repository.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
