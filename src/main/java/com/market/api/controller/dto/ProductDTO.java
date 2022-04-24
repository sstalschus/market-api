package com.market.api.controller.dto;

import com.market.api.config.ModelMapperConfig;
import com.market.api.domain.Product;
import com.market.api.domain.enums.MeasureType;
import com.market.api.util.EnumValidator;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Product dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

  private Long id;

  @NotNull(message = "The product name cannot be empty.")
  @Size(max = 40, message = "The product name must be less than 40 characters")
  private String name;

  @Valid
  private BrandDTO brand;

  @EnumValidator(
      enumClazz = MeasureType.class,
      message = "The measure must be type: KG or UNIT"
  )
  private String measure;

  @NotNull(message = "The product barcode cannot be empty.")
  @Size(max = 80, message = "The product name must be less than 80 characters")
  private String barcode;

  @NotNull(message = "The product quantity cannot be empty.")
  private Integer quantity;

  @NotNull(message = "The product price cannot be empty.")
  private BigDecimal price;

  private String picture;

  /**
   * Convert product dto.
   *
   * @param product the product
   * @return the product dto
   */
  public static ProductDTO convert(Product product) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(product, ProductDTO.class);
  }

  /**
   * Convert product.
   *
   * @param productDTO the product dto
   * @return the product
   */
  public static Product convert(ProductDTO productDTO) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(productDTO, Product.class);
  }

}
