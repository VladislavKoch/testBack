package com.example.testBack.errorHandling;


import com.example.testBack.dto.ErrorResponseDTO;
import com.example.testBack.dto.InternalErrorDTO;
import com.example.testBack.exception.DataIsNotCorrectException;
import com.example.testBack.exception.MyUserAuthenticationException;
import com.example.testBack.exception.MyUserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({MyUserNotFoundException.class, DataIsNotCorrectException.class,
            MyUserAuthenticationException.class})
    protected ResponseEntity<?> handleRestControllersExceptions(ResponseStatusException ex) {
        log.debug(ex.getReason());
        return new ResponseEntity<>(new ErrorResponseDTO(ex.getReason()), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleAllAnotherExceptions(Exception ex) {
        log.debug(ex.getMessage());
        return new ResponseEntity<>(new InternalErrorDTO(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
