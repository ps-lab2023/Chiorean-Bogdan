package com.example.notion_ex.repository;

import com.example.notion_ex.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
    User findByName(String name);
}
