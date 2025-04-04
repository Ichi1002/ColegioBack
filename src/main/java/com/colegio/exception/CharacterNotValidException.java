package com.colegio.exception;

public class CharacterNotValidException extends RuntimeException{
    private String error;
    public CharacterNotValidException(String error) {
        this.error = error;
    }
}
