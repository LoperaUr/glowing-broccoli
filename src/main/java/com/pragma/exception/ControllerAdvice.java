package com.pragma.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(GenericRuntimeException.class)
    public ResponseEntity<Map<String, String>> handleGenericRuntimeException(GenericRuntimeException e) {
        return new ResponseEntity<>(Map.of("message", e.getMessage()), e.getHttpStatus());
    }
}
