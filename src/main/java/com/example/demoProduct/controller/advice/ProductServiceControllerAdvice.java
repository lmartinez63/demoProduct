package com.example.demoProduct.controller.advice;

import com.example.demoProduct.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ProductServiceControllerAdvice {
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<?> productNotFoundException(EntityNotFoundException entityNotFoundException){
        log.error("action=controllerException productNotFoundException " + entityNotFoundException.getCustomMessage());
        return buildResponseEntity(entityNotFoundException.getCustomMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<?> buildResponseEntity(String exceptionMessage, HttpStatus httpStatus){
        return new ResponseEntity<>(exceptionMessage, httpStatus);
    }
}
