package com.example.journalapp.exception;
import com.example.journalapp.dtos.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserSignUpExeception.class)
    public ResponseEntity<APIResponse<Object>> handleUserSignUpException(UserSignUpExeception ex, WebRequest request) {
        APIResponse<Object> response = new APIResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                null,
                ex.getDetails()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
