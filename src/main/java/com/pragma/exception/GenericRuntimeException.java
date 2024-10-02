package com.pragma.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class GenericRuntimeException extends RuntimeException {

    private HttpStatus httpStatus;

    public GenericRuntimeException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
