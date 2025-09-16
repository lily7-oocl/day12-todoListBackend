package org.oocl.todolistbackend;

import org.junit.jupiter.api.Test;
import org.oocl.todolistbackend.controller.TodoController;
import org.oocl.todolistbackend.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    public void should_return_status_created_when_create_todo_given_todo() throws Exception {
        String requestBody = """
                {
                    "text": "是！哥们",
                    "done": false
                }
                """;
        mock.perform(post("/todos")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.text").value("是！哥们"))
                .andExpect(jsonPath("$.done").value(false));

    }

    @Test
    public void should_return_status_unprocessable_entity_when_create_todo_given_todo_with_empty_text() throws Exception {
        String requestBody = """
                {
                    "text": "",
                    "done": false
                }
                """;
        mock.perform(post("/todos")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void should_return_status_unprocessable_entity_when_create_todo_given_todo_with_null_text() throws Exception {
        String requestBody = """
                {
                    "done": false
                }
                """;
        mock.perform(post("/todos")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void should_return_not_found_when_update_todo_given_todo_id_not_exist() throws Exception {
        String requestBody = """
                {
                    "text": "是！哥们",
                    "done": false
                }
                """;
        mock.perform(put("/todos/999")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isNotFound());
    }

    @Test
    public void should_return_status_unprocessable_entity_when_update_todo_given_todo_is_empty() throws Exception {
        String requestBody = """
                {
                }
                """;
        mock.perform(put("/todos/123")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());
    }
}
