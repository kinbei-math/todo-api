package com.example.todo_api.form;

import java.time.LocalDate;

//データ転送用のオブジェクト　データを詰め込む箱のようなもの
public record TodoCreateForm (String title , LocalDate dueDate) {}
