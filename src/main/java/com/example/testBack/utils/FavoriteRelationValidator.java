package com.example.testBack.utils;

import com.example.testBack.entity.FavoriteRelation;
import com.example.testBack.service.serviceInterface.FavoriteRelationService;
import com.example.testBack.service.serviceInterface.FilmService;
import com.example.testBack.service.serviceInterface.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class FavoriteRelationValidator {
    private final MyUserService userService;
    private final FavoriteRelationService relationService;
    private final FilmService filmService;

    public void validate(FavoriteRelation relation, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        int filmId = relation.getFilmId();
        int userId = relation.getUserId();
        userService.findUserById(userId);
        if (relationService.existRelationByUserIdAndFilmId(userId, filmId)) {
            errors.rejectValue("filmId", "", "This relation is already exists");
        }
        if (!filmService.filmExistsById(filmId)) {
            errors.rejectValue("filmId", "", "This film is not exists");
        }
    }

}
