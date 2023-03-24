package com.example.notion_ex.repository;

import com.example.notion_ex.model.ProjectActivity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectActivityRepo extends CrudRepository<ProjectActivity, Long> {
    ProjectActivity findProjectActivityByProjectName(String s);
}
