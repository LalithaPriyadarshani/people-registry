package com.registry.exception;

import org.springframework.http.HttpStatus;

public class InvalidPersonalNumException extends RuntimeException{

    private final HttpStatus httpStatus;
    public InvalidPersonalNumException(String exception, HttpStatus httpStatus)
    {
        super(exception);
        this.httpStatus=httpStatus;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }
}
