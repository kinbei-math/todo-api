package com.example.todo_api.controller;

import com.example.todo_api.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo_api.form.TodoCreateForm;



@RestController //このクラスがWebAPIの窓口(コントローラー)であることを示すアノテーション
@RequestMapping("/todos") //URLが/todosで始まるリクエストを担当することを示すアノテーション
public class TodoController {
    private final TodoService todoService;// TodoServiceクラスのオブジェクト作成
    //コンストラクタ　ここでSpringBootがServiceを渡してくれる。いわゆる初期化
    public TodoController(TodoService todoService){
        this.todoService=todoService;
    }
    @PostMapping  //データの登録リクエスト(HTTP POST)を受け付ける
    public void createTodo(@RequestBody TodoCreateForm form) {
        todoService.createTodo(form); /* Serviceクラスにデータを渡して、Serviceクラスで作ってねという指示*/
    }
}
