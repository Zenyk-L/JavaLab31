package com.epam.project.spring.dto;

import com.epam.project.spring.controller.validation.ValidRole;
import com.epam.project.spring.dto.goup.OnCreate;
import com.epam.project.spring.dto.goup.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@JsonInclude(NON_NULL)
public class UserWithPasswordDto {

    @Null(message = "id should be empty", groups = OnCreate.class)
    private Integer id;

    @NotBlank(message = "firstName shouldn't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "lastName shouldn't be empty", groups = OnCreate.class)
    private String lastName;

    @Email
    @NotBlank(message = "email shouldn't be blank", groups = OnCreate.class)
    @Null(message = "email should be absent", groups = OnUpdate.class)
    private String email;

    @NotBlank(message = "password shouldn't be blank", groups = OnCreate.class)
    @NotEmpty(message = "password shouldn't be empty", groups = OnUpdate.class)
    private String password;

    @ValidRole
    private String role;

    @AssertFalse(message = "blocked shouldn't be true", groups = OnCreate.class)
    private boolean blocked;

}
