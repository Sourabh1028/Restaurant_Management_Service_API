package com.geekster.Restaurant_Management_Service_API.Service;

import com.geekster.Restaurant_Management_Service_API.Model.Admin;
import com.geekster.Restaurant_Management_Service_API.Repositary.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

    public boolean checkAdmin(String adminEmail) {
        return adminRepo.existsByAdminId(adminEmail);
    }

    public String addAdmin(Admin admin) {
        adminRepo.save(admin);
        return "admin saved";
    }
}
