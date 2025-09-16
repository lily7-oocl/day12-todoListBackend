package org.oocl.todolistbackend.repository.impl;

import lombok.AllArgsConstructor;
import org.oocl.todolistbackend.pojo.Todo;
import org.oocl.todolistbackend.repository.TodoRepository;
import org.oocl.todolistbackend.repository.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
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
}
