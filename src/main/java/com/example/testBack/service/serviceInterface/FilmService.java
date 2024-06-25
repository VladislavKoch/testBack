package com.example.testBack.service.serviceInterface;

import com.example.testBack.entity.Film;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional(readOnly = true)
public interface FilmService {
    @Transactional
    public Set<Film> saveNewFilms(Set<Film> films);
    Set<Film> getAllFilms();
    boolean filmExistsById(int id);
    Set<Film> getRecommendedFilms(String loaderType, int userId);
}
