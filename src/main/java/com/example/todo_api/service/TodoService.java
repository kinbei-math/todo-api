package com.example.todo_api.service;

import com.example.todo_api.repository.TodoRepository;
import org.springframework.stereotype.Service;
import com.example.todo_api.form.TodoCreateForm;

@Service //Service 実務をやるレイヤーであることを示すアノテーション
public class TodoService {
    private final TodoRepository todoRepository;
    // コンストラクタ
    public TodoService(TodoRepository todoRepository){//TodoRepositoryクラスの初期化
        this.todoRepository=todoRepository;
    }
    public void createTodo(TodoCreateForm form){ //@RequestBodyは不要　Serviceに届くころにはTodoCreateFormというオブジェクトになっている。
        todoRepository.insert(form);//todoRepositoryクラスのinsert関数
    }
}
