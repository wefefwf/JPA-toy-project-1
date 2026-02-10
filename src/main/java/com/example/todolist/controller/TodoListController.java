package com.example.todolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todolist.dto.TodoListDTO;
import com.example.todolist.service.TodoListService;
import com.example.todolist.service.TodoListServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/todolist")
@Log4j2
@RequiredArgsConstructor
public class TodoListController {
  
  private final TodoListService service; //impl자동주입 업캐스팅

  //목록
  @GetMapping("/list")
  public void list (Model model) {
    List<TodoListDTO> list = service.getList();
    model.addAttribute("list",list);

  }
  
  //등록가기
  @GetMapping("/register")
  public void register(){
    //등록 버튼이 눌리면 
    //register로 가라~
  }

  //등록처리하기
  @PostMapping("/register")
  public String register(TodoListDTO todoListDTO,RedirectAttributes redirectAttributes){

    service.register(todoListDTO);
    return "redirect:/todolist/list";
  }

  //상세보기 가야됨 ! 수정화면도 보러가야됨
  @GetMapping({"/read","/modify"})
  public void read(long no,Model model){
    TodoListDTO todoListDTO = service.read(no);
    model.addAttribute("dto",todoListDTO);
  }
  //삭제
  @GetMapping("/delete")
  public String delete(Long no,RedirectAttributes re ){
    service.remove(no);
    //re.addFlashAttribute("msg","삭제되었습니다.");
    return "redirect:/todolist/list";
  }

  //수정처리
  @PostMapping("/modify")
  public String modify(TodoListDTO todoListDTO, RedirectAttributes re){
    service.modify(todoListDTO);
    re.addAttribute("no",todoListDTO.getNo());
    return "redirect:/todolist/read";
  }
}

