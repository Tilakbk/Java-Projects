package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class CategoryAlreadyExistException extends RuntimeException {
    public CategoryAlreadyExistException(String message) {
        super(message);
    }
}
