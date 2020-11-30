package com.leo.adidasdemo.loginservice.controller;

import com.leo.adidasdemo.loginservice.model.Admin;
import com.leo.adidasdemo.loginservice.model.Result;
import com.leo.adidasdemo.loginservice.service.Adminservice;
import com.leo.adidasdemo.loginservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    private Adminservice adminservice;
    /**
     * Login controller
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        boolean login = adminservice.login(admin);
        if(login){  //如果验证成功
            Map<String,String> info = new HashMap<>();
            info.put("username",admin.getName());
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), admin.getName(), null);
            info.put("token",token);
            return new Result(true, "Login Success",info);
        }else{
            return new Result(false,"User name or password is wrong",null);
        }
    }
}
