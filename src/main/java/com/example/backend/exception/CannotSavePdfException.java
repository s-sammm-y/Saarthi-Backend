package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class CannotSavePdfException extends RuntimeException{
    
    public CannotSavePdfException(String text){
        super(text);
    }

    public CannotSavePdfException(String text,Throwable cause){
        super(text,cause);
    }
}
