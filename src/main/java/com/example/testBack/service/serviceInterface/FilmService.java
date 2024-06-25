package com.example.testBack.service.serviceInterface;

import com.example.testBack.entity.Film;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface FilmService {
    Set<Film> saveNewFilms(Set<Film> films);
}