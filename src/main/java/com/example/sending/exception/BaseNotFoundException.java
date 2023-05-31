package com.example.sending.exception;

import org.springframework.http.HttpStatus;

public class BaseNotFoundException extends BaseException{

    protected BaseNotFoundException(String message){
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
