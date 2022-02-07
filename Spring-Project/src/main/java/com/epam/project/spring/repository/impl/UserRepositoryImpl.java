package com.epam.project.spring.repository.impl;

import com.epam.project.spring.model.User;
import com.epam.project.spring.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> listUser = new ArrayList<>();

    @Override
    public User getUser(String email) {
        return listUser.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> listUsers() {
        return listUser;
    }

    @Override
    public User createUser(User user) {
         listUser.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        boolean isDeleted = listUser.removeIf(u -> u.getEmail().equals(email));
        if (isDeleted) {
            listUser.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        listUser.removeIf(u -> u.getEmail().equals(email));
    }
}
