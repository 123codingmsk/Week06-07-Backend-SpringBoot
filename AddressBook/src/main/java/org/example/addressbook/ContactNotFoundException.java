package org.example.addressbook;

public class ContactNotFoundException extends RuntimeException{
    private String message;

    ContactNotFoundException(String message) {
        super(message);
    }
}
