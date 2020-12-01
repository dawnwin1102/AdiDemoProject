package com.leo.adidasdemo.routeportal.service;

import com.leo.adidasdemo.routeportal.feign.RouteServiceFeignClinet;
import com.leo.adidasdemo.routeportal.model.Route;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HomeService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RouteServiceFeignClinet routeServiceFeignClinet;

    /**
     * request getAllRoute api
     * @return
     */
    public Iterable<Route> getAllRoute() {
        //Route[] routes = this.restTemplate.getForObject("http://localhost:8080/itinerary/getAllRoute", Route[].class);
        Route[] routes =routeServiceFeignClinet.getAllRoute();
        return Arrays.stream(routes).collect(Collectors.toList());
    }

    /**
     * request getItineraries api
     * @param orginal
     * @param destiny
     * @return
     */
    public Object getItineraries(String orginal, String destiny) {
        //String url = String.format("http://localhost:8080/itinerary/getItineraries?start=%s&end=%s", orginal, destiny);
        //Object routes = this.restTemplate.getForObject(url, Object.class);
        Object routes =routeServiceFeignClinet.getItineraries(orginal,destiny);
        return routes;
    }

    /**
     * Fallback method for getAllRouteFallback
     * @return
     */
    private  Iterable<Route> getAllRouteFallback() {
        return new ArrayList<Route>();
    }

    /**
     * Fallback method for getItineraries
     * @param orginal
     * @param destiny
     * @return
     */
    private Object getItinerariesFallback(String orginal, String destiny) {
        return  "";
    }
}
