package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class ComplaintNotFoundException extends RuntimeException {
    public ComplaintNotFoundException(String message) {
        super(message);
    }
}
