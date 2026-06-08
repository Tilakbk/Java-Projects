package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class ResolutionLogNotValidException extends RuntimeException {
    public ResolutionLogNotValidException(String message) {
        super(message);
    }
}
