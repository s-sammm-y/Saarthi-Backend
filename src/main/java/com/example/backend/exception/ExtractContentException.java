package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ExtractContentException extends RuntimeException{
    public ExtractContentException(String text){
        super(text);
    }

    public ExtractContentException(String text,Throwable t){
        super(text,t);
    }
}
