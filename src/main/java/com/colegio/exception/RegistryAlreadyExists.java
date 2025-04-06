package com.colegio.exception;

public class RegistryAlreadyExists extends RuntimeException{
    public RegistryAlreadyExists(String error) {
        super(error);
    }
}
