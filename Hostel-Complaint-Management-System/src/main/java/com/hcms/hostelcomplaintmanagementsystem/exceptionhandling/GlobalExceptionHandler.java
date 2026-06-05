package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;



@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ApiErrorDto>> handleValidationException(
            MethodArgumentNotValidException e, HttpServletRequest request) {

        List<ApiErrorDto> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ApiErrorDto(
                        HttpStatus.BAD_REQUEST.value(),
                        "Validation Failed",
                        error.getDefaultMessage(),
                        request.getRequestURI(),
                        error.getField()
                ))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiErrorDto> emailAlreadyExistsExceptionHandling(EmailAlreadyExistsException e,HttpServletRequest request)
    {
        ApiErrorDto error= new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "Email already exists",e.getMessage(),request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(PhoneAlreadyExistsException.class)
    public ResponseEntity<ApiErrorDto> phoneAlreadyExistsExceptionHandling(PhoneAlreadyExistsException e,HttpServletRequest request)
    {
        log.warn("Phone already exists: {}",e.getMessage());
        ApiErrorDto error= new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "Phone already exists",e.getMessage(),request.getRequestURI());
        return ResponseEntity.badRequest().body(error);


    }

    @ExceptionHandler(RoomNotValidException.class)
    public ResponseEntity<ApiErrorDto> roomNotValidExceptionHandling(RoomNotValidException e,HttpServletRequest request)
    {
        log.error("Room not valid: {}",e.getMessage());

        ApiErrorDto error= new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "Room Not valid",e.getMessage(),request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(HostelNotValidException.class)
    public ResponseEntity<ApiErrorDto> hostelNotValidExceptionHandling(HostelNotValidException e,HttpServletRequest request)
    {
        log.error("Hostel not valid: {}",e.getMessage());

        ApiErrorDto error= new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "Hostel Not valid",e.getMessage(),request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(StudentNotValidException.class)
    public ResponseEntity<ApiErrorDto> studentNotValidExceptionHandling(StudentNotValidException e,HttpServletRequest request)
    {
        log.error("Student not valid: {}",e.getMessage());

        ApiErrorDto error= new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "Student Not valid",e.getMessage(),request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(StaffNotValidException.class)
    public ResponseEntity<ApiErrorDto> staffNotValidExceptionHandling(StaffNotValidException e,HttpServletRequest request)
    {
        log.warn("Staff not valid: {}",e.getMessage());

        ApiErrorDto errorDto= new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), "Staff not valid",e.getMessage(),request.getRequestURI());

        return ResponseEntity.ok(errorDto);
    }
}
