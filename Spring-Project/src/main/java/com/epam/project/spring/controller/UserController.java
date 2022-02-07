package com.epam.project.spring.controller;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.model.User;
import com.epam.project.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    public List<UserDto> getAllUser(){
        return userService.listUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{email}")
    public UserDto getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public UserDto createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/{email}")
    public UserDto updateUser(@PathVariable String  email, @RequestBody User user){
       return userService.updateUser(email, user);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/{email}")
    public void delete(@PathVariable String email){
        userService.deleteUser(email);
    }


}
