package com.colegio.exception;

public class InvalidLengthException extends RuntimeException{
    private String error;
    public InvalidLengthException(String error) {
        this.error = error;
    }
}
