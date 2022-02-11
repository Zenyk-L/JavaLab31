package com.epam.project.spring.controller;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.dto.UserWithPasswordDto;
import com.epam.project.spring.dto.goup.OnCreate;
import com.epam.project.spring.dto.goup.OnUpdate;
import com.epam.project.spring.model.User;
import com.epam.project.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getAllUser() {
        return userService.listUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserWithPasswordDto userWithPasswordDto) {
        return userService.createUser(userWithPasswordDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserWithPasswordDto userWithPasswordDto) {
        return userService.updateUser(email, userWithPasswordDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        userService.deleteUser(email);
    }


}
