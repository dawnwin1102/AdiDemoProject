package com.leo.adidasdemo.itineraryservice.service;

import com.google.common.collect.Lists;
import com.leo.adidasdemo.itineraryservice.dao.RouteRepository;
import com.leo.adidasdemo.itineraryservice.entities.Route;
import com.leo.adidasdemo.itineraryservice.util.Graph;
import com.leo.adidasdemo.itineraryservice.util.Vertex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class PathService {
    @Autowired
    private Graph graph;
    @Autowired
    private RouteRepository routeRepository;

    private List<Route> routeList;
    private Map<String, List<Route>> routePerOrginal;

    /**
     * Get all routes from db
     * @return
     */
    public List<Route> getAllRoute() {
        List<Route> routeList = routeRepository.findAll();
        return routeList;
    }

    /**
     * Get shortest path
     * @param start
     * @param end
     * @return
     */
    public List<String> getShorestRoute(String start,String end) {
        //List<Route> routeList = routeRepository.findAll();
        //Map<String, List<Route>> routePerOrginal = this.routeList.stream().collect(groupingBy(Route::getOriginal));
        this.retriveData();
        this.routePerOrginal.forEach((k, v) -> {
            graph.addVertex(k, v.stream().map(
                    r -> new Vertex(r.getDestiny(), r.getCost()))
                    .collect(Collectors.toList()));
        });
        List<String> res= graph.getShortestPath(start,end);
        res.add(start);
        return Lists.reverse(res) ;
    }

    /**
     * Get least transit route
     * @param start
     * @param end
     * @return
     */
    public List<String> getLeastTransitRoute(String start,String end) {
        this.retriveData();
        this.routePerOrginal.forEach((k, v) -> {
            graph.addVertex(k, v.stream().map(
                    r -> new Vertex(r.getDestiny(), 1))
                    .collect(Collectors.toList()));
        });
        List<String> res= graph.getShortestPath(start,end);
        res.add(start);
        return Lists.reverse(res) ;
    }

    private void retriveData(){
        this.routeList = routeRepository.findAll();
        this.routePerOrginal=routeList.stream().collect(groupingBy(Route::getOriginal));
    }
}
