package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class PhoneAlreadyExistsException extends RuntimeException {
    public PhoneAlreadyExistsException(String s) {
        super(s);
    }
}
