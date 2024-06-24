package com.example.testBack.service;

import com.example.testBack.entity.MyUser;
import com.example.testBack.exception.MyUserNotFoundException;
import com.example.testBack.repository.MyUserRepository;
import com.example.testBack.service.serviceInterface.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    private final MyUserRepository userRepository;

    @Override
    public MyUser saveUser(MyUser user) {
        return userRepository.save(user);
    }

    @Override
    public MyUser updateUser(MyUser updatedUser) {
        MyUser obtainedUser = userRepository.findById(updatedUser.getId()).orElseThrow(MyUserNotFoundException::new);
        obtainedUser.setName(updatedUser.getName());
        obtainedUser.setUsername(updatedUser.getUsername());
        return userRepository.save(obtainedUser);
    }

    @Override
    public void deleteUserById(int id) {
        if (!userRepository.existsById(id)) {
            throw new MyUserNotFoundException();
        }
        userRepository.deleteById(id);
    }

    @Override
    public MyUser findUserById(int id) {
        return userRepository.findById(id).orElseThrow(MyUserNotFoundException::new);
    }
}
