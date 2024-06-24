package com.example.testBack.controller;

import com.example.testBack.dto.DtoConverter;
import com.example.testBack.dto.MyUserDTO;
import com.example.testBack.dto.MyUserUpdateDTO;
import com.example.testBack.entity.MyUser;
import com.example.testBack.service.serviceInterface.MyUserService;
import com.example.testBack.utils.ErrorsUtil;
import com.example.testBack.utils.MyUserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static com.example.testBack.utils.AuthenticationServiceMock.checkAuthentication;

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
        log.info(String.format("user registered : id-%s, %s", savedUser.getId(), LocalDateTime.now()));
        return converter.userToDto(savedUser);
    }

    @GetMapping("/{id}")
    public MyUserDTO getUser(@RequestHeader(value = "User-Id", required = false) Integer headerId,
                             @PathVariable("id") int id) {
        checkAuthentication(headerId, id);
        return converter.userToDto(userService.findUserById(id));
    }

    @PutMapping("/{id}")
    public MyUserDTO updateUser(@RequestHeader(value = "User-Id", required = false) Integer headerId,
                                @PathVariable("id") int id, @RequestBody @Valid MyUserUpdateDTO userDTO,
                                BindingResult bindingResult) {
        checkAuthentication(headerId, id);
        MyUser user = converter.updateDtoToUser(userDTO);
        enrichUser(user, id);
        userValidator.validateUpdate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            ErrorsUtil.sendErrorsToClient(bindingResult);
        }
        MyUser updatedUser = userService.updateUser(user);
        log.info(String.format("user updated : id-%s, %s", updatedUser.getId(), LocalDateTime.now()));
        return converter.userToDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@RequestHeader(value = "User-Id", required = false) Integer headerId,
                           @PathVariable("id") int id){
        checkAuthentication(headerId, id);
        userService.deleteUserById(id);
    }

    private void enrichUser(MyUser user, int id) {
        user.setId(id);
    }
}
