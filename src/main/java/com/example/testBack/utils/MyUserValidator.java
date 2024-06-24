package com.example.testBack.utils;

import com.example.testBack.entity.MyUser;
import com.example.testBack.exception.MyUserNotFoundException;
import com.example.testBack.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MyUserValidator {
    private final MyUserRepository userRepository;

    public void validateSave(MyUser user, Errors errors) {
        if (userRepository.existsByEmail(user.getEmail())) {
            errors.rejectValue("email", "", "This email is already used");
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            errors.rejectValue("username", "", "This username is already used");
        }
    }

    public void validateUpdate(MyUser updatedUser, Errors errors) {
        MyUser oldUser = userRepository.findById(updatedUser.getId()).orElseThrow(MyUserNotFoundException::new);
        if (!Objects.equals(updatedUser.getUsername(), oldUser.getUsername())) {
            if (userRepository.existsByUsername(updatedUser.getUsername())) {
                errors.rejectValue("username", "", "This username is already used");
            }
        }
    }
}
