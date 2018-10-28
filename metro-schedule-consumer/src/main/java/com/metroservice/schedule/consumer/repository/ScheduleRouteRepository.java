package com.metroservice.schedule.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import com.metroservice.schedule.consumer.model.RouteTO;

public interface ScheduleRouteRepository extends CrudRepository<RouteTO,Integer>{

}
