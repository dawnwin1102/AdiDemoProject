package com.leo.adidasdemo.routeservice.itineraryservice.dao;

import com.leo.adidasdemo.routeservice.itineraryservice.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
