package com.example.testBack.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDTO {
    @NotNull(message = "You must provide id")
    private int id;

    @NotNull(message = "You must provide title")
    private String title;

    @NotNull(message = "You must provide poster path")
    @JsonProperty("poster_path")
    private String posterPath;
}
