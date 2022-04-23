package com.market.api.exception.handler;

import com.market.api.domain.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Generic handler for default exceptions.
 *
 * @author Samuel Stalschus
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> defaultHandler(){
        return ResponseEntity.internalServerError().body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"));
    }
}