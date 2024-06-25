package com.example.testBack.dto;

import com.example.testBack.entity.FavoriteRelation;
import com.example.testBack.entity.Film;
import com.example.testBack.entity.MyUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoConverter {
    private final ModelMapper modelMapper;
    public MyUser dtoToUser(MyUserDTO dto) {
        return modelMapper.map(dto, MyUser.class);
    }
    public MyUserDTO userToDto(MyUser user) {
        return modelMapper.map(user, MyUserDTO.class);
    }
    public MyUser updateDtoToUser(MyUserUpdateDTO dto) {
        return modelMapper.map(dto, MyUser.class);
    }
    public Film dtoToFilm(FilmDTO dto) {
        return modelMapper.map(dto, Film.class);
    }
    public FilmDTO FilmToDto(Film film) {
        return modelMapper.map(film, FilmDTO.class);
    }
    public FavoriteRelation dtoToFavoriteRelation(FavoriteRelationDTO dto) {
        return FavoriteRelation.builder()
                .userId(dto.getUserId())
                .filmId(dto.getFilmId())
                .build();
    }
    public FavoriteRelationDTO favoriteRelationToDto(FavoriteRelation relation) {
        return modelMapper.map(relation, FavoriteRelationDTO.class);
    }
}
