package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgNotValidException(MethodArgumentNotValidException e)
    {

        Map<String,String> error= new HashMap<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(er->error.put(er.getField(),er.getDefaultMessage()));

        return ResponseEntity.badRequest().body(error);
    }
}
