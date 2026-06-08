package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class RoomAlreadyExistsException extends RuntimeException {
    public RoomAlreadyExistsException(String message) {
        super(message);
    }
}
