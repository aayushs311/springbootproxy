package com.example.productservice.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "Exception has been handled";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException() {
        return "RuntimeException has been handled";
    }
}
