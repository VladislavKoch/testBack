package com.example.testBack.utils;

import com.example.testBack.entity.MyUser;
import com.example.testBack.service.serviceInterface.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MyUserValidator {
    private final MyUserService userService;

    public void validateSave(MyUser user, Errors errors) {
        if (userService.existsByEmail(user.getEmail())) {
            errors.rejectValue("email", "", "This email is already used");
        }
        if (userService.existsByUsername(user.getUsername())) {
            errors.rejectValue("username", "", "This username is already used");
        }
    }

    public void validateUpdate(MyUser updatedUser, Errors errors) {
        MyUser oldUser = userService.findUserById(updatedUser.getId());
        if (!Objects.equals(updatedUser.getUsername(), oldUser.getUsername())) {
            if (userService.existsByUsername(updatedUser.getUsername())) {
                errors.rejectValue("username", "", "This username is already used");
            }
        }
    }
}
