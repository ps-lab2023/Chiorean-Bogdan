package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.User;
import com.example.notion_ex.repository.UserRepo;
import com.example.notion_ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    public UserRepo userRepo;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepo.findById(id).orElse(null));
    }

    @Override
    public User getUserByName(String name) {
        return userRepo.findByName(name);
    }

    /*//public User saveUser(User user){
        return userRepo.save(user);
    }*/

    @Override
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User " + id + " was removed from the database\n";
    }
}
