package com.example.testBack.errorHandling;

import com.example.testBack.dto.ErrorResponseDTO;
import com.example.testBack.exception.DataIsNotCorrectException;
import com.example.testBack.exception.MyUserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MyUserNotFoundException.class, DataIsNotCorrectException.class})
    protected ResponseEntity<?> handleRestControllersExceptions(ResponseStatusException ex) {
        log.debug(ex.getReason());
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getReason()), ex.getStatus());
    }
}
