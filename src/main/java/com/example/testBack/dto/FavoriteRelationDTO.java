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
public class FavoriteRelationDTO {
    @NotNull(message = "You must provide user_id")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "You must provide film_id")
    @JsonProperty("film_id")
    private Integer filmId;

}
