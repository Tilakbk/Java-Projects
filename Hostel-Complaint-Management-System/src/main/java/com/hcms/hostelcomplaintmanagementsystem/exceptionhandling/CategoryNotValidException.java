package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class CategoryNotValidException extends RuntimeException {
    public CategoryNotValidException(String message) {
        super(message);
    }
}
