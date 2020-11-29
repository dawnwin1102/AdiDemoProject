package com.leo.adidasdemo.routeportal.service;

import com.leo.adidasdemo.routeportal.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class HomeService {
    @Autowired
    private RestTemplate restTemplate;

    public Iterable<Route> getAllRoute(){
        Route[] routes=this.restTemplate.getForObject("http://localhost:8080/itinerary/getAllRoute",Route[].class);
        return Arrays.stream(routes).collect(Collectors.toList());
    }

    public Object getItineraries(String orginal, String destiny){
        String url=String.format("http://localhost:8080/itinerary/getItineraries?start=%s&end=%s",orginal,destiny) ;
        Object routes=this.restTemplate.getForObject(url,Object.class);
        return routes;
    }
}
