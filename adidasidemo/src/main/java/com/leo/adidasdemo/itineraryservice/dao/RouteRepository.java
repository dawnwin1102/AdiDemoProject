package com.leo.adidasdemo.itineraryservice.dao;

import com.leo.adidasdemo.itineraryservice.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
