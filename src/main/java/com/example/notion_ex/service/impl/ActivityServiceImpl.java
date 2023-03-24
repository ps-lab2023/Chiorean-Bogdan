package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.Activity;
import com.example.notion_ex.repository.ActivitiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl {
    @Autowired
    private ActivitiesRepo activitiesRepo;

    public Activity saveActivity(Activity activity) {
       return activitiesRepo.save(activity);
    }

    public List<Activity> saveActivities(List<Activity> activities) {
        return (List<Activity>) activitiesRepo.saveAll(activities);
    }

    public List<Activity> getActivities() {
        return (List<Activity>) activitiesRepo.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return Optional.ofNullable(activitiesRepo.findById(id).orElse(null));
    }

    public Activity getActivityByName(String name) {
        return activitiesRepo.findByName(name);
    }

    public String deleteById(Long id) {
        activitiesRepo.deleteById(id);
        return "Activity " + id + " was removed from the database\n";
    }

    public Activity updateActivity(Activity activity) {
        Activity existingActivity = activitiesRepo.findById(activity.getId()).orElse(null);
        existingActivity.setName(activity.getName());
        existingActivity.setDescription(activity.getDescription());
        existingActivity.setPriority(activity.getPriority());

        existingActivity.setUser(activity.getUser());

        return activitiesRepo.save(existingActivity);
    }
}
