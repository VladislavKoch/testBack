package com.example.testBack.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "film")
public class Film {
    @Id
    private int id;

    @NotNull(message = "You must provide title")
    private String title;

    @NotNull(message = "You must provide poster path")
    @Column(name = "poster_path")
    private String posterPath;
}
