package com.market.api.domain.dto;

import lombok.*;

/** Entity of DTO error message
 *
 * @author Samuel Stalschus
 *
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessageDTO {

    private Integer statusCode;

    private String message;
}
