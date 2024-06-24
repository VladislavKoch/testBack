package com.example.testBack.utils;

import com.example.testBack.entity.MyUser;
import com.example.testBack.exception.MyUserNotFoundException;
import com.example.testBack.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final MyUserRepository userRepository;
    @Override
    public boolean supports(Class<?> aClass) {
        return MyUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {}

    public void validateSave(MyUser user, Errors errors){
        if (userRepository.existsByEmail(user.getEmail())) {
            errors.rejectValue("email", "", "This email is already used");
        }
        if (userRepository.existsByUsername(user.getUsername())){
            errors.rejectValue("username", "", "This username is already used");
        }
    }

    public void validateUpdate(MyUser updatedUser, Errors errors){
        MyUser oldUser = userRepository.findById(updatedUser.getId()).orElseThrow(MyUserNotFoundException::new);
        if (!Objects.equals(updatedUser.getEmail(), oldUser.getEmail())) {
            if (userRepository.existsByEmail(updatedUser.getEmail())) {
                errors.rejectValue("email", "", "This email is already used");
            }
        }
    }
}
