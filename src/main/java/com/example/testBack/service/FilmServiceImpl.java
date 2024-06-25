package com.example.testBack.service;

import com.example.testBack.entity.Film;
import com.example.testBack.repository.FilmRepository;
import com.example.testBack.service.serviceInterface.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

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
    public Set<Film> getAllFilms(){
        return new HashSet<>(filmRepository.findAll());
    }
}
