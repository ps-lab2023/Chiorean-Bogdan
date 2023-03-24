package com.example.notion_ex.service;

import com.example.notion_ex.model.ToDoActivity;
import org.springframework.stereotype.Component;

@Component
public interface ToDoActivityService {
    ToDoActivity getToDoActivityByID(Long id);
    ToDoActivity getFirstToDoByName(String name);
    ToDoActivity updateToDo(ToDoActivity act);
    String deleteToDoById(Long id);
}
