package com.example.testBack.repository;

import com.example.testBack.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query(value = "SELECT f.* FROM film f LEFT JOIN favorite_relation fr ON f.id = fr.film_id AND " +
            "fr.user_id = ?1 WHERE fr.film_id IS NULL;", nativeQuery = true)
    public Set<Film> getRecommended(int userId);
}
