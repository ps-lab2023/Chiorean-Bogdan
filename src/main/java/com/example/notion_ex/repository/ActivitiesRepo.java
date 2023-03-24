package com.example.notion_ex.repository;

import com.example.notion_ex.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepo extends CrudRepository<Activity, Long> {
    Activity findByName(String name);
}
