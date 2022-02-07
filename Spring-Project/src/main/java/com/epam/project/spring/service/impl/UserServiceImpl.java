package com.epam.project.spring.service.impl;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.model.User;
import com.epam.project.spring.repository.UserRepository;
import com.epam.project.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("Get user with email {}", email);
        User user = userRepository.getUser(email);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> listUsers() {
        log.info("Get All users");
        return userRepository.listUsers().stream().map(this::mapUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(User user) {
        log.info("Create user with email {}", user.getEmail());
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, User user) {
        log.info("Update user with email {}", email);
        user = userRepository.updateUser(email, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("Delete user with email {}", email);
        userRepository.deleteUser(email);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .blocked(user.isBlocked())
                .build();
    }
}
