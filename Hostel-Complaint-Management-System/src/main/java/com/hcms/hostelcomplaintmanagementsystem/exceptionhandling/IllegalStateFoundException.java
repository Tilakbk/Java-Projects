package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class IllegalStateFoundException extends RuntimeException {
    public IllegalStateFoundException(String message) {
        super(message);
    }
}
