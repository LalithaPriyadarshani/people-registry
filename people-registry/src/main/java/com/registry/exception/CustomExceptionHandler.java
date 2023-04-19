package com.registry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends Throwable {

    private List<String> details;


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(new ErrorResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidPersonalNumException.class)
    public final ResponseEntity<Object> handlePersonalNumExceptions(InvalidPersonalNumException ex) {

        return new ResponseEntity(new ErrorResponse(ex.getMessage(),ex.getHttpStatus() ),ex.getHttpStatus());
    }
}
