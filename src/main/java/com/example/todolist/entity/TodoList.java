package com.example.todolist.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoList {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long no;//글 번호

  @Column(length = 100,nullable=false)
  private String todo; // 할 일 

  @Column(name = "duedate") //마감기한
  private LocalDateTime dueDate;

  //change애들
  public void changeTodo(String todo){
    this.todo = todo;
  }
  public void changeDueDate(LocalDateTime dueDate){
    this.dueDate = dueDate;
  }
}
