package com.epam.project.spring.service.exeption;

public class EntityNotFoundException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "'%s' with identifier '%s' was not found";

    public EntityNotFoundException(String entityName, String id) {
        super(String.format(MESSAGE_TEMPLATE, entityName, id));
    }
}
