package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
