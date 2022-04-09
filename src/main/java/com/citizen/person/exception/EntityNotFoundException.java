package com.citizen.person.exception;

import static java.lang.String.format;

/**
 * Thrown when an application tries to get a person , but an employee was not found
 */
public class EntityNotFoundException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "%s with id = %s not found.";

    public EntityNotFoundException(Long personId, String entity) {
        super(format(EXCEPTION_MESSAGE, entity, personId));
    }
}
