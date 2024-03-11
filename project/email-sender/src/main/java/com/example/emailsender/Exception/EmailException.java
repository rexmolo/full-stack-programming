package com.example.emailsender.Exception;

public class EmailException extends RuntimeException{

    public EmailException() {
    }

    public EmailException(String message) {
        super(message);
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
