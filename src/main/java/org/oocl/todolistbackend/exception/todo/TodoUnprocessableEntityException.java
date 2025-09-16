package org.oocl.todolistbackend.exception.todo;

public class TodoUnprocessableEntityException extends TodoException{
    public TodoUnprocessableEntityException(String message) {
        super(message);
    }
}
