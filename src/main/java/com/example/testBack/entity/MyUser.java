package com.example.testBack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "You must provide username")
    @Pattern(regexp = "[a-zA-Z]+", message = "Username must consist of letters of the Latin alphabet")
    private String username;

    @NotNull(message = "You must provide email")
    @Email(message = "You must provide correct email")
    private String email;

    private String name;
}
