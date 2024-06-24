package com.example.testBack.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyUserDTO {

    private Integer id;

    @NotNull(message = "You must provide username")
    @Pattern(regexp = "[a-zA-Z]+", message = "Username must consist of letters of the Latin alphabet")
    private String username;

    @NotNull(message = "You must provide email")
    @Email(message = "You must provide correct email")
    private String email;

    private String name;
}
