package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class StaffNotValidException extends RuntimeException {
    public StaffNotValidException(String message) {
        super(message);
    }
}
