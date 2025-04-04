package com.colegio.exception;

public class RegistryNotFoundException extends RuntimeException{
    private String error;
    public RegistryNotFoundException(String error){
        this.error = error;
    }
}
