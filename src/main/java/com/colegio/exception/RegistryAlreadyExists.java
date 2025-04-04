package com.colegio.exception;

public class RegistryAlreadyExists extends RuntimeException{
    private String error;
    public RegistryAlreadyExists(String error) {
        this.error = error;
    }
}
