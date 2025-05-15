package org.example;

public class ContactNotFoundException extends RuntimeException{
    private String message;

    ContactNotFoundException(String message) {
        super(message);
    }
}