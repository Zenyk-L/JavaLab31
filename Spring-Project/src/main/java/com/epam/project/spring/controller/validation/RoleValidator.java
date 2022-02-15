package com.epam.project.spring.controller.validation;

import com.epam.project.spring.model.UserRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class RoleValidator implements ConstraintValidator<ValidRole, String> {

    @Override
    public boolean isValid(String role, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(UserRole.values())
                .filter(userRole -> userRole.toString().equals(role))
                .findFirst()
                .isPresent();
    }
}
