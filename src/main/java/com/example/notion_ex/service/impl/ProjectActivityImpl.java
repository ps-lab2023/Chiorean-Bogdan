package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.Admin;
import com.example.notion_ex.model.ProjectActivity;
import com.example.notion_ex.repository.AdminRepo;
import com.example.notion_ex.repository.FinancialActivityRepo;
import com.example.notion_ex.repository.ProjectActivityRepo;
import com.example.notion_ex.service.ProjectActivityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectActivityImpl implements ProjectActivityService {
    @Autowired
    private ProjectActivityRepo projectActivityRepo;

    public ProjectActivityImpl(ProjectActivityRepo prActRepo) {
        this.projectActivityRepo = prActRepo;
    }

    //READ
    @Override
    public ProjectActivity findProjectByName(String name){
        return projectActivityRepo.findProjectActivityByProjectName(name);
    }

    //UPDATE
    @Override
    public ProjectActivity updateProject(ProjectActivity act) {
        ProjectActivity existing = projectActivityRepo.findById(act.getId()).orElse(null);
        existing.setTask(act.getTask());
        existing.setStatus(act.getStatus());

        //existingAdmin.;

        return projectActivityRepo.save(existing);
    }

    //DELETE
    @Override
    public String deleteProjectActivityById(Long id) {
        projectActivityRepo.deleteById(id);
        return "The project with the id: " + id + " was deleted from the database";
    }
}
