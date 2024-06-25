package com.example.testBack.service;

import com.example.testBack.entity.FavoriteRelation;
import com.example.testBack.repository.FavoriteRelationRepository;
import com.example.testBack.service.serviceInterface.FavoriteRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteRelationServiceImpl implements FavoriteRelationService {
    private final FavoriteRelationRepository relationRepository;

    @Override
    public FavoriteRelation addRelation(FavoriteRelation relation) {
        return relationRepository.save(relation);
    }

    @Override
    public void deleteRelation(FavoriteRelation relation) {
        relationRepository.deleteByFilmIdAndUserId(relation.getFilmId(), relation.getUserId());
    }

    @Override
    public boolean existRelationByUserIdAndFilmId(int userId, int filmId) {
        return relationRepository.existsFavoriteRelationByFilmIdAndUserId(filmId, userId);
    }

    @Override
    public List<FavoriteRelation> getAllRelations() {
        return relationRepository.findAll();
    }


}
