package com.example.notion_ex.service;

import com.example.notion_ex.model.ReadActivity;
import org.springframework.stereotype.Component;

@Component
public interface ReadActivityService {
    ReadActivity getReadActivityByID(Long id);
    ReadActivity getReadByType(String type);
    ReadActivity updateRead(ReadActivity act);
    String deleteReadById(Long id);
}
