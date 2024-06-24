package com.example.testBack.dto;

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
}
