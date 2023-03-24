package com.example.notion_ex.service;

import com.example.notion_ex.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {
    Optional<User> findById(Long id);
    User getUserByName(String name);
    String deleteUser(Long id);
}
