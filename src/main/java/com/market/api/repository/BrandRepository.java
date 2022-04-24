package com.market.api.repository;

import com.market.api.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Brand repository.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

  /**
   * Find by name brand.
   *
   * @param name the name
   * @return the brand
   */
  Brand findByName(String name);

}
