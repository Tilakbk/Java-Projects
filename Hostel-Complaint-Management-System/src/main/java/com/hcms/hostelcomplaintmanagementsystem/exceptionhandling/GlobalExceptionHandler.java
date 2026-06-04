package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgNotValidException(MethodArgumentNotValidException e)
    {

        Map<String,String> error= new HashMap<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(er->error.put(er.getField(),er.getDefaultMessage()));

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> emailAlreadyExistsException(EmailAlreadyExistsException e)
    {
        log.warn("Email already exists: {}",e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(PhoneAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> phoneAlreadyExistsException(PhoneAlreadyExistsException e)
    {
        log.warn("Phone already exists: {}",e.getMessage());
        Map<String,String> error=new HashMap<>();
        error.put("Error: ",e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(RoomNotValidException.class)
    public ResponseEntity<Map<String,String>> roomNotValidException(RoomNotValidException e)
    {
        log.error("Room not valid: {}",e.getMessage());
        Map<String,String> error=new HashMap<>();
        error.put("Error: ",e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(HostelNotValidException.class)
    public ResponseEntity<Map<String,String>> hostelNotValidException(HostelNotValidException e)
    {
        log.error("Hostel not valid: {}",e.getMessage());
        Map<String,String> error=new HashMap<>();
        error.put("Error: ",e.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
}
