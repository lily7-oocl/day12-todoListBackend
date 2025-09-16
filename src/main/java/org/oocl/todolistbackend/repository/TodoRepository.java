package org.oocl.todolistbackend.repository;

import org.oocl.todolistbackend.pojo.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> getAll();

    int save(Todo todo);
}
