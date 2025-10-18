package com.workintech.fswebs18challengemaven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<CardErrorResponse> handleException(CardException exception) {
        CardErrorResponse cardErrorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(cardErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<CardErrorResponse> handleException(Exception exception) {
        CardErrorResponse cardErrorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(cardErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
