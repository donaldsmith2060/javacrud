package com.example.demo.DAO;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDAO {

    public void update(User employee);
    public void delete(User employee);
    public User findById(int id);
    public List<User> getAllUsers();
}
