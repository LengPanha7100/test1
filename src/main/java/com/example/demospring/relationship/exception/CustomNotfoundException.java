package com.example.demospring.relationship.exception;

public class CustomNotfoundException extends RuntimeException {

    public CustomNotfoundException(String message) {
        super(message);
    }
}
