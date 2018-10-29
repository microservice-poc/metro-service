package com.metroservice.schedule.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import com.metroservice.schedule.consumer.model.TrainTO;

public interface ScheduleTrainRepository extends CrudRepository<TrainTO,Integer>{

}
