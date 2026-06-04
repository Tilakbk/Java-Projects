package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class StudentNotValidException extends RuntimeException {
    public StudentNotValidException(String message) {
        super(message);
    }
}
