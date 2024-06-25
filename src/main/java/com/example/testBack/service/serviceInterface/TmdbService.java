package com.example.testBack.service.serviceInterface;

import com.example.testBack.entity.Film;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface TmdbService {
    public Set<Film> findFirstFilms(int pages);
}
