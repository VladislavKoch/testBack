package com.example.testBack.utils;

import com.example.testBack.exception.MyUserAuthenticationException;
import com.example.testBack.exception.MyUserNotFoundException;
import com.example.testBack.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationServiceMock {
    private final MyUserRepository userRepository;

    public void checkAuthentication(Integer headerId, int id) {
        if (headerId == null) {
            throw new MyUserAuthenticationException("User-Id header is empty!");
        }
        if (headerId != id) {
            throw new MyUserAuthenticationException("User-Id header is not equals path id!");
        }
        if (!userRepository.existsById(headerId)) {
            throw new MyUserNotFoundException();
        }
    }
}
