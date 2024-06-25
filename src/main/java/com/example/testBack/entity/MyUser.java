package com.example.testBack.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "You must provide username")
    @Pattern(regexp = "[a-zA-Z]+", message = "Username must consist of letters of the Latin alphabet")
    private String username;

    @NotNull(message = "You must provide email")
    @Email(message = "You must provide correct email")
    private String email;

    private String name;
}
