package com.colegio.exception;

public class InvalidLengthException extends RuntimeException{
    public InvalidLengthException(String error) {
        super(error);
    }
}
