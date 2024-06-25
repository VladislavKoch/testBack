package com.example.testBack.controller;

import com.example.testBack.dto.DtoConverter;
import com.example.testBack.dto.FilmDTO;
import com.example.testBack.entity.Film;
import com.example.testBack.service.serviceInterface.FavoriteRelationService;
import com.example.testBack.service.serviceInterface.FilmService;
import com.example.testBack.utils.AuthenticationServiceMock;
import com.example.testBack.utils.FavoriteRelationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/films")
@RequiredArgsConstructor
@Slf4j
public class FilmRestController {
    private final FilmService filmService;
    private final DtoConverter converter;
    private final AuthenticationServiceMock authenticationService;
    private final FavoriteRelationService relationService;
    private final FavoriteRelationValidator relationValidator;

    @GetMapping()
    public List<FilmDTO> getFilms(@RequestParam(name = "film_per_page", defaultValue = "15") int filmsPerPage) {
        Set<Film> films = filmService.getAllFilms();
        return films.stream().limit(filmsPerPage).map(converter::FilmToDto).collect(Collectors.toList());
    }

}
