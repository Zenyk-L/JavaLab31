package com.epam.project.spring.repository;

import com.epam.project.spring.model.User;

import java.util.List;

public interface UserRepository {

    User getUser(String email);

    List<User> listUsers();

    User createUser(User user);

    User updateUser(String email, User user);

    void deleteUser(String email);

}
