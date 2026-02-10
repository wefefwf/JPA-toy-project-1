package com.example.todolist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todolist.dto.TodoListDTO;
import com.example.todolist.entity.TodoList;
import com.example.todolist.repository.TodoListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService{

  
  private final TodoListRepository repository;
  
  @Override
  public List<TodoListDTO> getList() {
   //상속 받음 목록 추상메서드
   //페이징 처리 안함
    List<TodoList> result = repository.findAll();

    //dto를 변환해서 처리 보내야됨
    List<TodoListDTO> list = new ArrayList<>();
    for(TodoList todoList : result){
      list.add(entityToDto(todoList));
    }

    return list;
  }

  //등록 처리
  @Override
  public void register(TodoListDTO todoListDTO) {
    //dto받아서 entity로
    TodoList todoList = dtoToEntity(todoListDTO);
    repository.save(todoList);
  }

  //게시물하나들고오기
  @Override
  public TodoListDTO read(long no) {
   Optional<TodoList> result = repository.findById(no);
   TodoListDTO todoListDTO = null;
   if(result.isPresent()){
    todoListDTO = entityToDto(result.get());
  }
  //반환
  return todoListDTO;
  }

  //삭제
  @Override
  public void remove(long no) {
     //게시물 번호로 삭제 
     repository.deleteById(no);
  }

  //수정처리
  @Override
  public void modify(TodoListDTO todoListDTO) {
    Optional<TodoList> result = repository.findById(todoListDTO.getNo());
    if(result.isPresent()){
      TodoList todoList = result.get();
      todoList.changeTodo(todoListDTO.getTodo());
      todoList.changeDueDate(todoListDTO.getDueDate());
      repository.save(todoList);
    }
  }
 

  
}
