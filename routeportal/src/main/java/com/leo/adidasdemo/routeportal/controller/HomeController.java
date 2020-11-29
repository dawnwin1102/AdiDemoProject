package com.leo.adidasdemo.routeportal.controller;

import com.google.common.base.Strings;
import com.leo.adidasdemo.routeportal.model.ResponseWarpper;
import com.leo.adidasdemo.routeportal.model.Route;
import com.leo.adidasdemo.routeportal.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/getAllRoute")
    public Iterable<Route> getAllRoute() {
        Iterable<Route> res = homeService.getAllRoute();
        return res;
    }

    @GetMapping("/getItineraries")
    public ResponseWarpper getItineraries (String orginal, String destiny) {
        if (Strings.isNullOrEmpty(orginal)||Strings.isNullOrEmpty(destiny))
        {
            return new ResponseWarpper(HttpStatus.BAD_REQUEST.value(),"orginal or destiny should not be empty.");
        }
        Object res = homeService.getItineraries(orginal,destiny);
        return new ResponseWarpper(HttpStatus.OK.value(), res);
    }
}
