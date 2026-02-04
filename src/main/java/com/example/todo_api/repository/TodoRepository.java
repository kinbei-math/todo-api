package com.example.todo_api.repository;

import com.example.todo_api.entity.Todo;
import com.example.todo_api.form.TodoCreateForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository //Repositoryはinterfaceで定義する
public interface TodoRepository extends JpaRepository<Todo,Integer>{
}
