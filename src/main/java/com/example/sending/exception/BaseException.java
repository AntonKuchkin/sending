package com.example.sending.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException{

    protected BaseException(String message) {
        super(message);
    }

    protected BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();
}
