package com.example.web.service;

import com.example.web.model.User;

import java.util.List;

public interface UserService {
    public User getUser(long id);

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(long id);
}
