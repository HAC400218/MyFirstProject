package com.trafficlight.sys.controller;

import org.springframework.http.HttpStatus;
import com.trafficlight.sys.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

       @ExceptionHandler(IllegalStateException.class)
       public ErrorResponse handleStateException(IllegalStateException exception){
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
       }
}
