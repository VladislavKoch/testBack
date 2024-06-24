package com.example.testBack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
