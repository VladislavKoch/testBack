package com.example.testBack.service;

import com.example.testBack.entity.FavoriteRelation;
import com.example.testBack.entity.Film;
import com.example.testBack.exception.DataIsNotCorrectException;
import com.example.testBack.repository.FilmRepository;
import com.example.testBack.service.serviceInterface.FavoriteRelationService;
import com.example.testBack.service.serviceInterface.FilmService;
import com.example.testBack.service.serviceInterface.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FavoriteRelationService relationService;
    private final MyUserService userService;

    @Override
    public Set<Film> saveNewFilms(Set<Film> obtainedFilms) {
        Set<Film> savedFilms = new HashSet<>(filmRepository.findAll());
        if (!savedFilms.isEmpty()) {
            obtainedFilms.removeAll(savedFilms);
        }
        if (!obtainedFilms.isEmpty()) {
            filmRepository.saveAll(obtainedFilms);
        }
        return obtainedFilms;
    }

    @Override
    public Set<Film> getAllFilms() {
        return new HashSet<>(filmRepository.findAll());
    }

    @Override
    public boolean filmExistsById(int id) {
        return filmRepository.existsById(id);
    }

    @Override
    public Set<Film> getRecommendedFilms(String loaderType, int userId) {
        userService.findUserById(userId);
        return switch (loaderType) {
            case "sql" -> filmRepository.getRecommended(userId);
            case "inMemory" -> {
                Set<Integer> watchedFilmsIds = relationService.getAllRelations().stream()
                        .filter(x -> x.getUserId() == userId).map(FavoriteRelation::getFilmId).collect(Collectors.toSet());
                yield filmRepository.findAll().stream().filter(x -> !(watchedFilmsIds.contains(x.getId())))
                        .collect(Collectors.toSet());
            }
            default -> throw new DataIsNotCorrectException("loaderType must be sql or inMemory");
        };
    }
}
