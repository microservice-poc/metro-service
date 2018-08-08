package com.metroservice.route.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.metroservice.route.data.entity.Station;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends CrudRepository<Station, Long> {

}