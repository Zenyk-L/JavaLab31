package com.epam.project.spring.service;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.model.User;

import java.util.List;

public interface UserService {

    UserDto getUser(String email);

    List<UserDto> listUsers();

    UserDto createUser(User user);

    UserDto updateUser(String email, User user);

    void deleteUser(String email);
}
