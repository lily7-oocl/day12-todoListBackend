package org.oocl.todolistbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.pojo.dto.TodoDto;
import org.oocl.todolistbackend.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@Valid @RequestBody TodoDto todo) {
        return todoService.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodoById(@PathVariable int id) {
        todoService.deleteTodoById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTodoById(@Valid @RequestBody TodoDto todo, @PathVariable int id) {
        todoService.updateTodoById(todo, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }
}
