package com.leo.adidasdemo.routeservice;

import com.google.common.collect.Lists;
import com.leo.adidasdemo.routeservice.itineraryservice.entities.Route;
import com.leo.adidasdemo.routeservice.itineraryservice.util.Graph;
import com.leo.adidasdemo.routeservice.itineraryservice.util.Vertex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    @DisplayName("grapShouldReturnShortestPath")
    void grapShouldReturnShortestPath() {
        Graph g = new Graph();
        g.addVertex("SH", Arrays.asList(new Vertex("HZ", 3), new Vertex("SZ", 2)));
        g.addVertex("SH", Arrays.asList(new Vertex("WH", 1), new Vertex("CQ", 1)));
        g.addVertex("SZ", Arrays.asList(new Vertex("CD", 1), new Vertex("NJ", 1)));
        g.addVertex("WH", Arrays.asList(new Vertex("CQ", 1), new Vertex("CD", 1)));
        g.addVertex("NJ", Arrays.asList(new Vertex("SH", 1)));
        g.addVertex("CQ", Arrays.asList(new Vertex("SZ", 1)));
        g.addVertex("CD", Arrays.asList(new Vertex("SZ", 1)));
        List<String> result= Lists.reverse(g.getShortestPath("SH","NJ"));
        String resStr=String.join(",",result);
        assertEquals("CQ,SZ,NJ", resStr, "Shortest path from HS to NJ should be:SH->CQ->SZ->NJ");
    }

}


