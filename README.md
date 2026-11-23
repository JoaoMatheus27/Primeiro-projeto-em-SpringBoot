package com.joaomatheus.agenda.shared.exception;

import org.springframework.web.bind;

@MethodArgumentNotValidException
@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(GlobalExceptionHandler.class)
    public ProblemDetail tratarValidacao(MethodArgumentNotValidException){
        
    }
}
