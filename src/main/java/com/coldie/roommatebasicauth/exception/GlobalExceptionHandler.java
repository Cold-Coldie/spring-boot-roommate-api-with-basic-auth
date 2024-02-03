package com.coldie.roommatebasicauth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoommateNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRoommateNotFoundException(RoommateNotFoundException ex) {
        // Create a custom ErrorResponse object
        ErrorResponse response = new ErrorResponse("404", "Not Found", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
