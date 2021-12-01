package com.example.actorservice.controller.exception;

import com.example.actorservice.exception.EntityNotFound;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFound.class)
    public ErrorMessage entityNotFoundHandler(EntityNotFound exception, HttpServletRequest request) {
        return new ErrorMessage(exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(BindException.class)
    public Map<String, String> bindExceptionHandler(BindException bindException) {
        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = bindException.getBindingResult();
        bindingResult.getFieldErrors().forEach(
                fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return errors;
    }
}
