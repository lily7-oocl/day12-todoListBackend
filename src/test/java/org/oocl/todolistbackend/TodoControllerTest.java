package org.oocl.todolistbackend;

import org.junit.jupiter.api.Test;
import org.oocl.todolistbackend.controller.TodoController;
import org.oocl.todolistbackend.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {
    @Autowired
    private MockMvc mock;
    @Autowired
    private TodoController todoController;
    @Test
    public void should_return_all_todos_when_get_all_todos() throws Exception {
        List<Todo> allTodos = todoController.getAllTodos();
        mock.perform(get("/todos/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(allTodos.size()));
    }
}
