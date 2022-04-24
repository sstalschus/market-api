package com.market.api.controller.dto;

import com.market.api.config.ModelMapperConfig;
import com.market.api.domain.Brand;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Brand dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandDTO {

  @NotNull(message = "The brand name cannot be empty.")
  @Size(max = 15, message = "The brand name must be less than 15 characters")
  private String name;

  /**
   * Convert brand dto.
   *
   * @param brand the brand
   * @return the brand dto
   */
  public static BrandDTO convert(Brand brand) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(brand, BrandDTO.class);
  }

  /**
   * Convert brand.
   *
   * @param brandDTO the brand dto
   * @return the brand
   */
  public static Brand convert(BrandDTO brandDTO) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(brandDTO, Brand.class);
  }

}
