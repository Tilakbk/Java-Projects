package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException(String message) {
        super(message);
    }
}
