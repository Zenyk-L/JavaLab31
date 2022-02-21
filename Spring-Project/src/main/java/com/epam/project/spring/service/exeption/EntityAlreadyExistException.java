package com.epam.project.spring.service.exeption;

public class EntityAlreadyExistException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "'%s' with identifier '%s' already exist";

    public EntityAlreadyExistException(String entityName, String id) {
        super(String.format(MESSAGE_TEMPLATE, entityName, id));
    }
}
