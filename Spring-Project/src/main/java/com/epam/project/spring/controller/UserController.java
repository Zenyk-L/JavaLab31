package com.epam.project.spring.controller;

import com.epam.project.spring.dto.UserDto;
import com.epam.project.spring.dto.UserWithPasswordDto;
import com.epam.project.spring.dto.goup.OnCreate;
import com.epam.project.spring.dto.goup.OnUpdate;
import com.epam.project.spring.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Api(tags = "User management API")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public class UserController {

    private final UserService userService;


    @ApiOperation("Get all users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getAllUser() {
        return userService.listUsers();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Get user by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}")
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @ApiOperation("Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserWithPasswordDto userWithPasswordDto) {
        return userService.createUser(userWithPasswordDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Update user by email")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody @Validated(OnUpdate.class) UserWithPasswordDto userWithPasswordDto) {
        return userService.updateUser(email, userWithPasswordDto);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
    })
    @ApiOperation("Delete user by email")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        userService.deleteUser(email);
    }


}
