package com.market.api.domain.dto;

import com.market.api.config.ModelMapperConfig;
import com.market.api.domain.Product;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;

    private String name;

    private String brand;

    private String barcode;

    public static ProductDTO convert(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDTO.class);
    }

    public static Product convert(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDTO, Product.class);
    }
}
