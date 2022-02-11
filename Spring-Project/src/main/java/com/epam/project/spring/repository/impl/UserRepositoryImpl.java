package com.epam.project.spring.repository.impl;

import com.epam.project.spring.model.User;
import com.epam.project.spring.repository.UserRepository;
import com.epam.project.spring.service.exeption.EntityAlreadyExistException;
import com.epam.project.spring.service.exeption.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<User> listUsers() {
        return listUser;
    }

    @Override
    public User createUser(User user) {
        boolean userNotExist = listUser.stream()
                .filter(u -> u.getEmail()
                        .equals(user.getEmail()))
                .findFirst()
                .isEmpty();
        if (userNotExist) {
            user.setId(idCount++);
            listUser.add(user);
        } else {
            throw new EntityAlreadyExistException("User with email " + user.getEmail() + " already exist");
        }
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        AtomicReference<Integer> userId = new AtomicReference<>();
        boolean isDeleted = listUser.removeIf(u -> {
            userId.set(u.getId());
            return u.getEmail()
                    .equals(email);
        });
        if (isDeleted) {
            user.setId(userId.get());
            listUser.add(user);
        } else {
            throw new EntityNotFoundException("User is not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(String email) {
        listUser.removeIf(u -> u.getEmail()
                .equals(email));
    }
}
