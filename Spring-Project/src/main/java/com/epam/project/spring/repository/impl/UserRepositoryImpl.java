package com.epam.project.spring.repository.impl;

import com.epam.project.spring.model.User;
import com.epam.project.spring.repository.UserRepository;
import com.epam.project.spring.service.exeption.EntityAlreadyExistException;
import com.epam.project.spring.service.exeption.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> listUser = new ArrayList<>();

    private static int idCount = 1;

    @Override
    public User getUser(String email) {
        return listUser.stream()
                .filter(user -> user.getEmail()
                        .equals(email))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("User", email));
    }

    @Override
    public List<User> listUsers() {
        return listUser;
    }

    @Override
    public User createUser(User user) {

        boolean userAlreadyExist = listUser.stream()
                .anyMatch(u -> u.getEmail().equals(user.getEmail()));
        if (userAlreadyExist) {
            throw new EntityAlreadyExistException("User", user.getEmail());
        } else {
            user.setId(idCount++);
            listUser.add(user);
        }
        return user;
    }

    @Override
    public User updateUser(String email, User user) {

        return listUser.stream()
                .filter(u -> u.getEmail()
                        .equals(email))
                .findFirst()
                .map(u -> {
                    user.setId(u.getId());
                    user.setEmail(email);
                    listUser.remove(u);
                    listUser.add(user);
                    return user;
                })
                .orElseThrow(() -> new EntityNotFoundException("User", email));
    }

    @Override
    public void deleteUser(String email) {
        listUser.removeIf(u -> u.getEmail()
                .equals(email));
    }
}
