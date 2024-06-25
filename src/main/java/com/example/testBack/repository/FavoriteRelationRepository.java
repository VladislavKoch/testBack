package com.example.testBack.repository;

import com.example.testBack.entity.FavoriteRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRelationRepository extends JpaRepository<FavoriteRelation, Integer> {
    public boolean existsFavoriteRelationByFilmIdAndUserId(int filmId, int userId);
    public void deleteByFilmIdAndUserId(int filmId, int userId);
}
