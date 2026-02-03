package com.example.todo_api.repository;

import com.example.todo_api.form.TodoCreateForm;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
    public void insert(TodoCreateForm form){
        System.out.println("DBに保存しました："+form);
    }
}
