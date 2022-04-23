package com.market.api.controller.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade de DTO de Mensagem de parâmetros inválidos para serem usados a partir do @valid.
 *
 * @author Samuel Stalschus
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvalidParamsDTO {

  private Integer statusCode;

  private String message;

  private Map<?, ?> arguments;

}