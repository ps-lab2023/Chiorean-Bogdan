package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.Admin;
import com.example.notion_ex.model.ReadActivity;
import com.example.notion_ex.model.ToDoActivity;
import com.example.notion_ex.repository.AdminRepo;
import com.example.notion_ex.repository.ReadActivityRepo;
import com.example.notion_ex.repository.ToDoActivityRepo;
import com.example.notion_ex.service.ToDoActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoActivityImpl implements ToDoActivityService {
    @Autowired
    private ToDoActivityRepo toDoActivityRepo;

    public ToDoActivityImpl(ToDoActivityRepo toDoActRepo) {
        this.toDoActivityRepo = toDoActRepo;
    }
    //READ
    @Override
    public ToDoActivity getToDoActivityByID(Long id) {
        return toDoActivityRepo.findById(id).orElse(null);
    }

    @Override
    public ToDoActivity getFirstToDoByName(String name) {
        return toDoActivityRepo.findFirstByTaskName(name);
    }

    //UPDATE

    @Override
    public ToDoActivity updateToDo(ToDoActivity act) {
        ToDoActivity existing = toDoActivityRepo.findById(act.getId()).orElse(null);
        existing.setTaskName(act.getTaskName());
        existing.setUser(act.getUser());

        return toDoActivityRepo.save(existing);
    }

    @Override
    public String deleteToDoById(Long id) {
        toDoActivityRepo.deleteById(id);
        return "To Do activity with id: " + id + " was deleted from the database\n";
    }
}
