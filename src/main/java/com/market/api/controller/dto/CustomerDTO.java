package com.market.api.controller.dto;

import com.market.api.config.ModelMapperConfig;
import com.market.api.domain.Customer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Customer dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

  private Long id;

  @NotNull(message = "The customer name cannot be empty.")
  @Size(max = 15, message = "The customer name must be less than 15 characters")
  private String name;

  @NotNull(message = "The customer email cannot be empty.")
  @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email format not valid")
  private String email;

  @NotNull(message = "The customer phone cannot be empty.")
  private String phone;

  /**
   * Convert customer dto.
   *
   * @param customer the customer
   * @return the customer dto
   */
  public static CustomerDTO convert(Customer customer) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(customer, CustomerDTO.class);
  }

  /**
   * Convert customer.
   *
   * @param customerDTO the customer dto
   * @return the customer
   */
  public static Customer convert(CustomerDTO customerDTO) {
    return ModelMapperConfig.ModelMapperConfig()
        .map(customerDTO, Customer.class);
  }

}
