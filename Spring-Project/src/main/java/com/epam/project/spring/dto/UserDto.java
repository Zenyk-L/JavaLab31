package com.epam.project.spring.dto;

import com.epam.project.spring.model.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
    private boolean blocked;

}
