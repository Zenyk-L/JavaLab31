package com.epam.project.spring.service;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.dto.UserWithPasswordDto;

import java.util.List;

public interface UserService {

    UserDto getUser(String email);

    List<UserDto> listUsers();

    UserDto createUser(UserWithPasswordDto userWithPasswordDto);

    UserDto updateUser(String email, UserWithPasswordDto userWithPasswordDto);

    void deleteUser(String email);
}
