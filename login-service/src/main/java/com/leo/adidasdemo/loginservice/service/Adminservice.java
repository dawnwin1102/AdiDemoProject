package com.leo.adidasdemo.loginservice.service;

import com.leo.adidasdemo.loginservice.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class Adminservice {
    public boolean login(Admin admin) {
        if ("admin".equals(admin.getName()) && "12345".equals(admin.getPassword())) {
            return true;
        }
        return false;
    }
}
