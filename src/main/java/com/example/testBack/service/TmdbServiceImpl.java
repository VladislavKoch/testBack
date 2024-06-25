package com.example.testBack.service;

import com.example.testBack.dto.DtoConverter;
import com.example.testBack.dto.TmdbResponseDTO;
import com.example.testBack.entity.Film;
import com.example.testBack.service.serviceInterface.TmdbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TmdbServiceImpl implements TmdbService {
    private final RestTemplate restTemplate;
    private final DtoConverter converter;

    @Value("${tmdb.token}")
    String bearerToken;
    @Value("${tmdb.url}")
    String tmdbUrl;

    @Override
    public Set<Film> findFirstFilms(int pages) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", bearerToken);
        Set<Film> films = new HashSet<>();
        for (int i = 1; i <= pages; i++) {
            String url = tmdbUrl + i;
            try {
                ResponseEntity<TmdbResponseDTO> filmResponse =
                        restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
                                new ParameterizedTypeReference<>() {});
                TmdbResponseDTO responseDto = filmResponse.getBody();
                films.addAll(responseDto.getResults().stream().map(converter::dtoToFilm).collect(Collectors.toSet()));
            } catch (RestClientException | NullPointerException ex) {
                log.warn(ex.getLocalizedMessage());
            }
        }
        return films;
    }
}