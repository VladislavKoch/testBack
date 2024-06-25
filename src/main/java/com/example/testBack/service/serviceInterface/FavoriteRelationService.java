package com.example.testBack.service.serviceInterface;

import com.example.testBack.entity.FavoriteRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface FavoriteRelationService {
    public FavoriteRelation addRelation(FavoriteRelation relation);
    public void deleteRelation(FavoriteRelation relation);
    @Transactional(readOnly = true)
    public boolean existRelationByUserIdAndFilmId(int userId, int filmId);
    @Transactional(readOnly = true)
    public List<FavoriteRelation> getAllRelations();
}
