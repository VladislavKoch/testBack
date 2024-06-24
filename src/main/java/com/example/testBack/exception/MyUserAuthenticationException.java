package com.example.testBack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MyUserAuthenticationException extends ResponseStatusException {
    public MyUserAuthenticationException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
