package com.example.testBack.utils;

import com.example.testBack.exception.MyUserAuthenticationException;

public class AuthenticationServiceMock {
    public static void checkAuthentication(Integer headerId, int id) {
        if (headerId == null) {
            throw new MyUserAuthenticationException("User-Id header is empty!");
        } else if (headerId != id) {
            throw new MyUserAuthenticationException("User-Id header is not equals path id!");
        }
    }
}
