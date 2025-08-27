package com.example.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleResourceNotFoundException(ResourceNotFoundException ex){
        Map<String,String> message = new HashMap<>();
        message.put("message", "Resource Not Found:"+ex.getMessage());
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CannotSavePdfException.class)
    public ResponseEntity<Map<String,Object>> handleCannotSavePdfException(CannotSavePdfException ex){
        return ResponseEntity
        .status(HttpStatus.SERVICE_UNAVAILABLE)
        .body(
            Map.of("message","Cannot save PDF",
            "error",ex.getMessage()));
    }

    @ExceptionHandler(ExtractContentException.class)
    public ResponseEntity<Map<String,Object>> handleExtractContentException(ExtractContentException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(Map.of("message","Error extracting pdf data","error",ex.getMessage()));
    }
}
