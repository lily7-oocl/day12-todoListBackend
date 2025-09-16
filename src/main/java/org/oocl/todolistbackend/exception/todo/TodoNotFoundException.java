package org.oocl.todolistbackend.exception.todo;

public class TodoNotFoundException extends TodoException {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
