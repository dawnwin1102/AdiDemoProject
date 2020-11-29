package com.leo.adidasdemo.routeportal.feign;

import com.leo.adidasdemo.routeportal.model.Route;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "routeservice")
public interface RouteServiceFeignClinet {
    @RequestMapping(value = "/itinerary/getAllRoute", method = RequestMethod.GET)
    public Route[] getAllRoute();
    @RequestMapping(value = "/itinerary/getItineraries", method = RequestMethod.GET)
    public Object getItineraries(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end);
}
