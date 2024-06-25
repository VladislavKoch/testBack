package com.example.testBack.dto;

import com.example.testBack.entity.Film;
import lombok.*;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImdbResponseDTO {
    private int page;
    private Set<Film> results;
}
