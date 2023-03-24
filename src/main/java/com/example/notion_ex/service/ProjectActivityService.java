package com.example.notion_ex.service;

import com.example.notion_ex.model.ProjectActivity;
import org.springframework.stereotype.Component;

@Component
public interface ProjectActivityService {
    ProjectActivity findProjectByName(String name);
    ProjectActivity updateProject(ProjectActivity act);
    String deleteProjectActivityById(Long id);
}
