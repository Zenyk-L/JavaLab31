package com.epam.project.spring.service;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.dto.UserWithPasswordDto;

import java.util.List;

public interface UserService {

    UserWithPasswordDto getUser(String email);

    List<UserWithPasswordDto> listUsers();

    UserWithPasswordDto createUser(UserWithPasswordDto userWithPasswordDto);

    UserWithPasswordDto updateUser(String email, UserWithPasswordDto userWithPasswordDto);

    void deleteUser(String email);
}
