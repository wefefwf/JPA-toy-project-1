package com.example.todolist.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
public class TodoListDTO {

  private Long no;//글 번호

  private String todo; // 할 일 
  
  private LocalDateTime dueDate; //마감 기한 

}
