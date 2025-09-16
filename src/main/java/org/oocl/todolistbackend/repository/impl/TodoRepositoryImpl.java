package org.oocl.todolistbackend.repository.impl;

import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.exception.todo.TodoNotFoundException;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.repository.TodoRepository;
import org.oocl.todolistbackend.repository.dao.TodoDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {
    private TodoDao todoDao;

    @Override
    public List<Todo> getAll() {
        return todoDao.findAll();
    }

    @Override
    public int save(Todo todo) {
        return todoDao.save(todo).getId();
    }

    @Override
    public void deleteById(int id) {
        todoDao.deleteById((long) id);
    }

    @Override
    public void updateById(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    public Todo getById(int id) {
        return todoDao.findById((long) id).orElseThrow(()->new TodoNotFoundException("Not Found"));
    }
}
