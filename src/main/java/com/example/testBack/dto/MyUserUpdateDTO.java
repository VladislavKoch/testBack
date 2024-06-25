package com.example.testBack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyUserUpdateDTO {

    @NotNull(message = "You must provide username")
    @Pattern(regexp = "[a-zA-Z]+", message = "Username must consist of letters of the Latin alphabet")
    private String username;

    private String name;
}
