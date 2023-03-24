package com.example.notion_ex.service;

import com.example.notion_ex.model.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {
    List<Admin> getAdmins();

    Admin findByName(String name);

    Admin updateAdmin(Admin admin1);
    String deleteAdminById(Long id);
}
