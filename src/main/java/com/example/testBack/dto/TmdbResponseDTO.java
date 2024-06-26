package com.example.testBack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TmdbResponseDTO {
    private int page;
    private Set<FilmDTO> results;
}
