package com.example.notion_ex.service.impl;

import com.example.notion_ex.model.Admin;
import com.example.notion_ex.repository.AdminRepo;
import com.example.notion_ex.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public AdminImpl(AdminRepo admRepo) {
        this.adminRepo = admRepo;
    }

    //READ
    @Override
    public List<Admin> getAdmins(){
        return (List<Admin>) adminRepo.findAll();
    }

    @Override
    public Admin findByName(String name) { return adminRepo.findAdminByName(name); }

    //UPDATE
    @Override
    public Admin updateAdmin(Admin admin1) {
        Admin existingAdmin = adminRepo.findById(admin1.getId()).orElse(null);
        existingAdmin.setName(admin1.getName());

        //existingAdmin.;

        return adminRepo.save(existingAdmin);
    }

    //DELETE
    @Override
    public String deleteAdminById(Long id) {
        adminRepo.deleteById(id);
        return "The admin with id " + id + " was deleted from the database";
    }
}
