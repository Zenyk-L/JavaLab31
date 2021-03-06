package com.epam.project.spring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private UserRole role;

    private boolean blocked;
}
