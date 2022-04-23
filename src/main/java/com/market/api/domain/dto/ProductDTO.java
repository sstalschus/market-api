package com.market.api.domain.dto;

import com.market.api.domain.Product;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

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

    private String brand;

    @NotNull(message = "The product barcode cannot be empty.")
    @Size(max = 80, message = "The product name must be less than 80 characters")
    private String barcode;

    @NotNull(message = "The product quantity cannot be empty.")
    private Integer quantity;

    @NotNull(message = "The product price cannot be empty.")
    private BigDecimal price;

    public static ProductDTO convert(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product convert(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDTO, Product.class);
    }
}
