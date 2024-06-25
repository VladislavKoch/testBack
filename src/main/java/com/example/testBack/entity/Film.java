package com.example.testBack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
