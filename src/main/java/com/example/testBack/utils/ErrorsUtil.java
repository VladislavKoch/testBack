package com.example.testBack.utils;

import com.example.testBack.exception.DataIsNotCorrectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
@Slf4j
public class ErrorsUtil {
    public static void sendErrorsToClient(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            stringBuilder.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
        }
        throw new DataIsNotCorrectException(stringBuilder.toString());
    }
}
