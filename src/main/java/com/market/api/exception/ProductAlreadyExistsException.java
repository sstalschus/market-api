package com.market.api.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception containing relevant information for product API errors.
 *
 * @author Samuel Stalschus
 */
public class ProductAlreadyExistsException extends ApiException {

    private static final long serialVersionUID = -525546673970530803L;

    private static final String BAD_REQUEST_CODE = "bad_request";

    /**
     * Creates a new instance, with provided cause.
     *
     * @param e cause
     */
    public ProductAlreadyExistsException(Throwable e) {
        super(
                BAD_REQUEST_CODE,
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.value(),
                e);
    }

    /**
     * Creates a new instance, with provided cause and custom message.
     *
     * @param message custom message.
     * @param e cause.
     */
    public ProductAlreadyExistsException(String message, Throwable e) {
        super(BAD_REQUEST_CODE, message, HttpStatus.BAD_REQUEST.value(), e);
    }

    /**
     * Creates a new instance, with provided cause and custom message.
     *
     * @param message custom message.
     */
    public ProductAlreadyExistsException(String message) {
        super(BAD_REQUEST_CODE, message, HttpStatus.BAD_REQUEST.value());
    }
}

