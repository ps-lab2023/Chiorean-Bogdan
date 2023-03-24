package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.Activity;
import com.example.notion_ex.model.ReadActivity;
import com.example.notion_ex.repository.ReadActivityRepo;
import com.example.notion_ex.service.ReadActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadActivityImpl implements ReadActivityService {
    @Autowired
    private ReadActivityRepo readActivityRepo;

    public ReadActivityImpl(ReadActivityRepo readActRepo) {
        this.readActivityRepo = readActRepo;
    }

    //READ
    @Override
    public ReadActivity getReadActivityByID(Long id) {
        return readActivityRepo.findById(id).orElse(null);
    }

    @Override
    public ReadActivity getReadByType(String type) {
        return readActivityRepo.findReadActivityByType(type);
    }

    //UPDATE

    @Override
    public ReadActivity updateRead(ReadActivity act) {
        ReadActivity existing = readActivityRepo.findById(act.getId()).orElse(null);
        existing.setName(act.getName());
        existing.setAuthor(act.getAuthor());
        existing.setStatus(act.getStatus());

        existing.setUser(act.getUser());

        return readActivityRepo.save(existing);
    }

    @Override
    public String deleteReadById(Long id) {
        readActivityRepo.deleteById(id);
        return "Read activity with id: " + id + " was deleted from the database\n";
    }
}
