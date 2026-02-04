package com.example.todo_api.service;

import com.example.todo_api.entity.Todo;
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
        Todo todo = new Todo(); // 受け渡し用の箱を作る。受け渡す用に加工
        todo.setTask(form.title());//その箱にデータを詰める
        todoRepository.save(todo);//箱をデータベースに保存する。
    }
}
