package com.example.testBack.service.serviceInterface;

import com.example.testBack.entity.FavoriteRelation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FavoriteRelationService {
    public FavoriteRelation addRelation(FavoriteRelation relation);
    @Transactional(readOnly = true)
    public boolean existRelationByUserIdAndFilmId(int userId, int filmId);
}
