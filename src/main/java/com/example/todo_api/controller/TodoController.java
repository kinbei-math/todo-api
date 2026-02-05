package com.example.todo_api.controller;

import com.example.todo_api.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.todo_api.form.TodoCreateForm;
import java.time.LocalDate;


@RestController //このクラスがWebAPIの窓口(コントローラー)であることを示すアノテーション
@RequestMapping("/todos") //URLが/todosで始まるリクエストを担当することを示すアノテーション
public class TodoController {
    private final TodoService todoService;// Springが作成したServiceを受け取り保持
    //コンストラクタ　ここでSpringBootがServiceを渡してくれる。いわゆる初期化
    public TodoController(TodoService todoService){
        this.todoService=todoService;
    }
    // レスポンス用のrecord　TodoCreateFormと同型だが、こっちはレスポンス用。受取はしない。
    public record TodoResponse(String title , LocalDate dueDate){}

    @PostMapping()  //データの登録リクエスト(HTTP POST)を受け付ける
    @ResponseStatus(HttpStatus.CREATED) //201を返す
    public TodoResponse createTodo(@RequestBody TodoCreateForm form) {
        todoService.createTodo(form); /* Serviceクラスにデータを渡して、Serviceクラスで作ってねという指示*/
        TodoResponse todoResponse=new TodoResponse(form.title(),form.dueDate());
        return todoResponse;
    }
}
