package org.oocl.todolistbackend.service;

import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.pojo.dto.TodoDto;
import org.oocl.todolistbackend.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.getAll();
    }

    public Todo addTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);
        todo.setId(todoRepository.save(todo));
        return todo;
    }

    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }
}
