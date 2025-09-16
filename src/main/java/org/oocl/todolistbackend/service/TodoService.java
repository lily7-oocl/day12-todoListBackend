package org.oocl.todolistbackend.service;

import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;
    public List<Todo> getAllTodos() {
        return todoRepository.getAll();
    }
}
