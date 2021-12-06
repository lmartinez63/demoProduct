package com.example.demoProduct.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{
    private final String customMessage;
    public EntityNotFoundException(String customMessage){
        super();
        this.customMessage = customMessage;
    }
}
