package com.example.actorservice.exception;

public class EntityNotFound extends RuntimeException{
    private String message;

    public EntityNotFound(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
