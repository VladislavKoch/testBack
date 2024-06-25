package com.example.testBack.controller;

import com.example.testBack.dto.DtoConverter;
import com.example.testBack.dto.FavoriteRelationDTO;
import com.example.testBack.entity.FavoriteRelation;
import com.example.testBack.service.serviceInterface.FavoriteRelationService;
import com.example.testBack.utils.AuthenticationServiceMock;
import com.example.testBack.utils.ErrorsUtil;
import com.example.testBack.utils.FavoriteRelationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
@Slf4j
public class FavoriteRelationRestController {
    private final DtoConverter converter;
    private final AuthenticationServiceMock authenticationService;
    private final FavoriteRelationService relationService;
    private final FavoriteRelationValidator relationValidator;

    @PostMapping()
    public FavoriteRelationDTO addToFavorite(@RequestHeader(value = "User-Id", required = false) Integer userId,
                                             @RequestBody @Valid FavoriteRelationDTO relationDTO,
                                             BindingResult bindingResult) {
        authenticationService.checkAuthentication(userId, relationDTO.getUserId());
        FavoriteRelation relation = converter.dtoToFavoriteRelation(relationDTO);
        relationValidator.validate(relation, bindingResult);
        if (bindingResult.hasErrors()) {
            ErrorsUtil.sendErrorsToClient(bindingResult);
        }
        return converter.favoriteRelationToDto(relationService.addRelation(relation));
    }
}
