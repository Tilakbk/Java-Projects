package com.hcms.hostelcomplaintmanagementsystem.exceptionhandling;

public class RoomNotValidException extends RuntimeException {
    public RoomNotValidException(String message) {
        super(message);
    }
}
