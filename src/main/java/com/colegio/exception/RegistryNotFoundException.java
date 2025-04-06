package com.colegio.exception;

public class RegistryNotFoundException extends RuntimeException{
    public RegistryNotFoundException(String error){
        super(error);
    }
}
