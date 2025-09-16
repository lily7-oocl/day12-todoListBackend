package org.oocl.todolistbackend.exception;

import jakarta.validation.ConstraintViolationException;
import org.oocl.todolistbackend.exception.todo.TodoException;
import org.oocl.todolistbackend.exception.todo.TodoNotFoundException;
import org.oocl.todolistbackend.exception.todo.TodoUnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleIllegalArgumentException(ConstraintViolationException e) {
        return e.getMessage();
    }

    @ExceptionHandler(TodoException.class)
    public ResponseEntity<String> handleTodoException(TodoException e) {
        if (e instanceof TodoNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } else if (e instanceof TodoUnprocessableEntityException) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
