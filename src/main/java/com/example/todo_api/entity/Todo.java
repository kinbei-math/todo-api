package com.example.todo_api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //以下のクラスをデータベースに保存するためのテーブルとする
public class Todo {

    @Id // データの番号(通し番号)をこれで設定する
    @GeneratedValue(strategy= GenerationType.IDENTITY)//自動採番　こちらで設定しなくても自動で振ってくれる。
    private Integer id;
    private String task;

    public void setTask(String task){//Todoの中身を変更できるようにしている。
        this.task=task;
    }
}