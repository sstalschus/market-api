package com.market.api.controller.dto;

import com.market.api.config.ModelMapperConfig;
import com.market.api.domain.CarShopping;
import java.util.List;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Car shopping dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarShoppingDTO {

  private Long id;

  private List<ProductDTO> products;

  @Valid
  private CustomerDTO customerDTO;

  /**
   * Convert car shopping dto.
   *
   * @param carShopping the car shopping
   * @return the car shopping dto
   */
  public static CarShoppingDTO convert(CarShopping carShopping) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(carShopping, CarShoppingDTO.class);
  }

  /**
   * Convert car shopping.
   *
   * @param carShoppingDTO the car shopping dto
   * @return the car shopping
   */
  public static CarShopping convert(CarShoppingDTO carShoppingDTO) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(carShoppingDTO, CarShopping.class);
  }

}
