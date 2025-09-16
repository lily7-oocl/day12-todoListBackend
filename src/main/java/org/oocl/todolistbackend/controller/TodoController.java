package org.oocl.todolistbackend.controller;

import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}
