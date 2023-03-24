package com.example.notion_ex.repository;

import com.example.notion_ex.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {
    Admin findAdminByName(String name);
}
