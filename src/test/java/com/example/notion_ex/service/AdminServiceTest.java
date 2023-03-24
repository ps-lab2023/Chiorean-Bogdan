package com.example.notion_ex.service;

import com.example.notion_ex.model.Admin;
import com.example.notion_ex.model.Client;
import com.example.notion_ex.repository.AdminRepo;
import com.example.notion_ex.repository.ClientRepo;
import com.example.notion_ex.service.impl.AdminImpl;
import com.example.notion_ex.service.impl.ClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AdminServiceTest {
    private static final String ADMIN_NAME = "Costel";
    private static final String NOT_ADMIN_NAME = "GIGEL";
    private static final String ADMIN_UPDATE = "Costelica";

    private AdminImpl adminImpl;

    @Mock
    private AdminRepo adminRepo;

    private Admin admin;

    @BeforeEach
    void init() {
        initMocks(this);
        admin = new Admin();
        admin.setName(ADMIN_NAME);
        when(adminRepo.findAdminByName(ADMIN_NAME)).thenReturn(admin);
    }

    @Test
    void givenExistingAdmin_Name_whenFindByName_thenFindOne() {
        adminImpl = new AdminImpl(adminRepo);
        Admin admin2 = adminImpl.findByName(ADMIN_NAME);

        assertNotNull(admin2);
        assertEquals(ADMIN_NAME, admin2.getName());
    }

    @Test
    void givenNonExistingAdmin_Name_whenFindByName_thenThrowException() {
        when(adminRepo.findAdminByName(NOT_ADMIN_NAME)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            adminImpl.findByName(NOT_ADMIN_NAME);
        });
    }

    @Test
    void givenExistingAdmin_whenUpdate_thenUpdate() {
        adminImpl = new AdminImpl(adminRepo);
        Admin admin1 = new Admin();
        admin1.setId(2L);
        admin1.setName(ADMIN_UPDATE);

        adminImpl.updateAdmin(admin1);
        assertNotNull(admin1);
        assertEquals(ADMIN_UPDATE, admin1.getName());
    }
}
