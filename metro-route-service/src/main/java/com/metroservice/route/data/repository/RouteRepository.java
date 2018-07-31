package com.metroservice.route.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.metroservice.route.data.entity.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

}