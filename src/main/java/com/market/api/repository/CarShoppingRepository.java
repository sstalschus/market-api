package com.market.api.repository;

import com.market.api.domain.CarShopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Car shopping repository.
 */
@Repository
public interface CarShoppingRepository extends JpaRepository<CarShopping, Long> {

}
