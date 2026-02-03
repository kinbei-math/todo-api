package com.example.todo_api.form;

//データ転送用のオブジェクト　データを詰め込む箱のようなもの
public record TodoCreateForm (String title ,String dueDate) {}
