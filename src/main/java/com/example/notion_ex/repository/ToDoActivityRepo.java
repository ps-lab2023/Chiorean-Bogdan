package com.example.notion_ex.repository;

import com.example.notion_ex.model.ToDoActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoActivityRepo extends CrudRepository<ToDoActivity, Long> {
    ToDoActivity findFirstByTaskName(String taskName);
}
