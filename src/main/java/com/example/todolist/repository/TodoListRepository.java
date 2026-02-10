package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.todolist.entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList,Long>{
 
  //기본 메서드 사용가능 
  //findById,findAll,save같은거 
  //더 추가하고싶다면내가 쿼리메서드 추가


}
