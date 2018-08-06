package com.metroservice.schedule.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.metroservice.schedule.data.entity.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer>{

}
