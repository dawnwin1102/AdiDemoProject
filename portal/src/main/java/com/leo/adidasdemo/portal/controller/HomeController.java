package com.leo.adidasdemo.portal.controller;

import com.leo.adidasdemo.portal.model.Route;
import com.leo.adidasdemo.portal.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/getAllRoute")
    public Iterable<Route> getAllRoute() {
        Iterable<Route> res = homeService.getAllRoute();
        return res;
    }
}
