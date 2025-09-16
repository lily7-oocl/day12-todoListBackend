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
                .andExpect(status().isCreated());
    }

    @Test
    public void should_return_status_no_content_when_delete_todo_by_id() throws Exception {
        int id = todoController.createOrUpdateTodo(new Todo("是！哥们", false)).get("id");
        mock.perform(delete("/todos/{id}", id))
                .andExpect(status().isNoContent());
    }
}
