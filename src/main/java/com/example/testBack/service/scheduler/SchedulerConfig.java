package com.example.testBack.service.scheduler;

import com.example.testBack.entity.Film;
import com.example.testBack.service.serviceInterface.FilmService;
import com.example.testBack.service.serviceInterface.TmdbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@EnableScheduling
@Component
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfig {
    private final FilmService filmService;
    private final TmdbService tmdbService;

    @Scheduled(cron = "0 0 0,3,6,9,12,15,18,21 * * *")
    public void everyThreeHourTmdbRequest() {
        Set<Film> films = tmdbService.findFirstFilms(5);
        Set<Film> savedFilms = filmService.saveNewFilms(films);
        if (!savedFilms.isEmpty()) {
            log.info(String.format("ID: %s films are added %s", savedFilms.stream()
                    .map(Film::getId).collect(Collectors.toList()), LocalDateTime.now()));
        }
    }
}
