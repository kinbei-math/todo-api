package com.example.todo_api;

import com.example.todo_api.controller.TodoController;
import com.example.todo_api.service.TodoService;

import tools.jackson.databind.ObjectMapper; // SpringBoot4で更新された
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired MockMvc mockMvc;          // 擬似HTTPを投げる道具
    @Autowired ObjectMapper objectMapper; // DTO/record → JSON文字列にする道具

    @MockitoBean TodoService todoService; // Controllerが依存してるServiceをモックで差し替え

    // 送るJSONの形（Controllerが受け取る形と “完全一致” させる）
    record CreateTodoRequest(String title, LocalDate dueDate) {}

    @Test
    void postTodo() throws Exception {
        var req = new CreateTodoRequest("課題", LocalDate.parse("2026-02-10"));
        String json = objectMapper.writeValueAsString(req);

        mockMvc.perform(
                        post("/todos") // ★ここはControllerのURLに合わせる（/todos かも）
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andDo(print())
                .andExpect(status().isCreated()) // 201
                .andExpect(jsonPath("$.title").value("課題"))
                .andExpect(jsonPath("$.dueDate").value("2026-02-10"));
                verify(todoService).createTodo(any());
    }
}
