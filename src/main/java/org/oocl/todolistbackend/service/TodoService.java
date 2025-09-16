package org.oocl.todolistbackend.service;

import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.getAll();
    }

    public int createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
