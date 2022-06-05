package com.market.api.controller.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Invalid Parameter Message DTO Entity to be used from @valid.
 *
 * @author Samuel Stalschus
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageDTO {

  private Integer statusCode;

  private String message;

  private Map<?, ?> arguments;

}