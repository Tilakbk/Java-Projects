package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class HostelNotValidException extends RuntimeException {
    public HostelNotValidException(String message) {
        super(message);
    }
}
