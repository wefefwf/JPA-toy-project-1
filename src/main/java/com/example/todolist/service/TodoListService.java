package com.example.todolist.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.todolist.dto.TodoListDTO;
import com.example.todolist.entity.TodoList;

public interface TodoListService {
  //목록
  List<TodoListDTO> getList();

  //등록처리
  void register(TodoListDTO todoListDTO);

  //하나 상세 읽기
  TodoListDTO read(long no);

  //삭제하기
  void remove(long no);

  //수정하기
  void modify(TodoListDTO todoListDTO);

  // entity to dto
  default TodoListDTO entityToDto(TodoList entity){
    TodoListDTO todoListDTO=TodoListDTO.builder()
                            .no(entity.getNo())
                            .todo(entity.getTodo())
                            .dueDate(entity.getDueDate())
                            .build();
    return todoListDTO;
  }

  // dto to entity
  default TodoList dtoToEntity(TodoListDTO todoListDTO){
    TodoList todoList=TodoList.builder()
                      .no(todoListDTO.getNo())
                      .todo(todoListDTO.getTodo())
                      .dueDate(todoListDTO.getDueDate())
                      .build();
    return todoList;
  }
}
