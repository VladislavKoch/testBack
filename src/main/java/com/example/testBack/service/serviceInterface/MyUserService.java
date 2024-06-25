package com.example.testBack.service.serviceInterface;

import com.example.testBack.entity.MyUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MyUserService {
    public MyUser saveUser(MyUser user);
    public MyUser updateUser(MyUser user);
    public void deleteUserById(int id);
    @Transactional(readOnly = true)
    public MyUser findUserById(int id);
    @Transactional(readOnly = true)
    public boolean existsByUsername(String username);
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email);
}
