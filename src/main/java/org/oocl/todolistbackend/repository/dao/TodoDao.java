package org.oocl.todolistbackend.repository.dao;

import org.oocl.todolistbackend.pojo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo, Long> {
}
