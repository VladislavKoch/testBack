package com.example.testBack.dto;

import com.example.testBack.entity.Film;
import lombok.*;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TmdbResponseDTO {
    private int page;
    private Set<FilmDTO> results;
}
