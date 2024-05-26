package com.example.journalapp.exception;

import lombok.Getter;

@Getter
public class CustomBaseException extends RuntimeException {
    private final String message;
    private final Object details;

    public CustomBaseException(String message, Object details) {
        super(message);
        this.message = message;
        this.details = details;
    }
}

