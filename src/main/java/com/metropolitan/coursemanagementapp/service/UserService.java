package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer userId);

    User getUserByUsernameAndPassword(String username, String password);

    User getUserByEmail(String email);

    User saveUser(User user);

    User updateUser(User user);

    void deleteById(Integer userId);

}
