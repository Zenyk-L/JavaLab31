package com.epam.project.spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWithPasswordDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

    private boolean blocked;

}
