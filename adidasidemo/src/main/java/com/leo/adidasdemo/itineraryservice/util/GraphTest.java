package com.leo.adidasdemo.itineraryservice.util;

import com.google.common.collect.Lists;
import com.leo.adidasdemo.itineraryservice.entities.Route;

import java.util.*;
import java.util.stream.Collectors;

public class GraphTest {
    public static void main(String[] args) {
        List<Route> routes=new ArrayList<>();
        Route route=new Route();
        route.setOriginal("sh");
        route.setDestiny("nj");
        route.setCost(3);
        Route route2=new Route();
        route2.setOriginal("sh");
        route2.setDestiny("bj");
        route2.setCost(10);
        routes.add(route);
        routes.add(route2);
        List<Vertex> vlist= routes.stream().map(r->new Vertex(r.getOriginal(),r.getCost())).collect(Collectors.toList());
        Graph g = new Graph();
        g.addVertex("SH", Arrays.asList(new Vertex("HZ", 3), new Vertex("SZ", 2)));
        g.addVertex("HZ", Arrays.asList(new Vertex("WH", 4), new Vertex("CQ", 14)));
        g.addVertex("SZ", Arrays.asList(new Vertex("CD", 10), new Vertex("NJ", 3)));
        g.addVertex("WH", Arrays.asList(new Vertex("CQ", 6), new Vertex("CD", 11)));
        g.addVertex("NJ", Arrays.asList(new Vertex("SH", 6)));
        g.addVertex("CQ", Arrays.asList(new Vertex("SZ", 15)));
        g.addVertex("CD", Arrays.asList(new Vertex("SZ", 10)));
//        g.addVertex('H', Arrays.asList(new Vertex('E', 1), new Vertex('F', 3)));
        System.out.println("route:SH=>CD");
        System.out.println(Lists.reverse(g.getShortestPath("SH", "CD")));
        System.out.println("route:NJ=>WH");
        System.out.println(Lists.reverse(g.getShortestPath("NJ", "WH")));
    }

}


