package com.example.journalapp.exception;

public class UserSignUpExeception extends CustomBaseException{
    public UserSignUpExeception(final String message, final Object details) {
        super(message, details);
    }
}
