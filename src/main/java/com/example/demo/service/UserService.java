package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
    User getUserById(Integer userId);
    void saveUser(User user);
    void delUser(User user);
    List<User> getAllUsers();
}
