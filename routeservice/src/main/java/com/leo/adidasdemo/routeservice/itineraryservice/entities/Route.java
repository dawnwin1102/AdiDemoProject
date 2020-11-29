package com.leo.adidasdemo.routeservice.itineraryservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String original;
    private String destiny;
    private String departuretime;
    private String arrivaltime;
    private Integer cost;

}