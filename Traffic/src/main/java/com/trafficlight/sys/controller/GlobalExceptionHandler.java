package com.trafficlight.sys.controller;

import org.springframework.http.HttpStatus;
import com.trafficlight.sys.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

       @ExceptionHandler(IllegalStateException.class)
       public ResponseEntity<ErrorResponse> handleStateException(IllegalStateException exception){
           ErrorResponse errorResponse=new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
           return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
       }
}
