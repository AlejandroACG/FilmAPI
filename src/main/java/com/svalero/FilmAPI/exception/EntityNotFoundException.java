package com.svalero.FilmAPI.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity, long id) {
        super(entity + " " + id + " not found");
    }
}
