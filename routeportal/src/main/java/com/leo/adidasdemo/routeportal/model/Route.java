package com.leo.adidasdemo.routeportal.model;

import lombok.Data;

@Data
public class Route {
    private Integer id;
    private String original;
    private String destiny;
    private String departuretime;
    private String arrivaltime;
    private Integer cost;

}