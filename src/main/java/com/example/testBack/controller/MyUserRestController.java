package com.example.testBack.controller;

import com.example.testBack.dto.DtoConverter;
import com.example.testBack.dto.MyUserDTO;
import com.example.testBack.entity.MyUser;
import com.example.testBack.service.serviceInterface.MyUserService;
import com.example.testBack.utils.ErrorsUtil;
import com.example.testBack.utils.MyUserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class MyUserRestController {
    private final MyUserService userService;
    private final DtoConverter converter;
    private final MyUserValidator userValidator;

    @PostMapping()
    public MyUserDTO createUser(@RequestBody @Valid MyUserDTO userDTO, BindingResult bindingResult) {
        MyUser user = converter.dtoToUser(userDTO);
        userValidator.validateSave(user, bindingResult);
        if (bindingResult.hasErrors()) {
            ErrorsUtil.sendErrorsToClient(bindingResult);
        }
        MyUser savedUser = userService.saveUser(user);
        log.info(String.format("user registered %s", LocalDateTime.now()));
        return converter.userToDto(savedUser);
    }
}
