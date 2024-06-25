package com.example.testBack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name= "favorite_relation")
public class FavoriteRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "You must provide user id")
    @Column(name = "user_id")
    private Integer userId;

    @NotNull(message = "You must provide film id")
    @Column(name = "film_id")
    private Integer filmId;

}