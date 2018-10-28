package com.metroservice.schedule.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroservice.schedule.consumer.model.RouteTO;
import com.metroservice.schedule.consumer.model.TrainTO;
import com.metroservice.schedule.consumer.repository.ScheduleRouteRepository;
import com.metroservice.schedule.consumer.repository.ScheduleTrainRepository;

@Service
public class ScheduleConsumerService {

	@Autowired
	private ScheduleTrainRepository scheduleTrainRepository;
	@Autowired
	private ScheduleRouteRepository scheduleRouteRepository;
	
	public String sayHello() {
		return "Hello!";
	}

	public boolean isTrainExist(Long sid) {
		return scheduleTrainRepository.exists(Integer.valueOf(sid.intValue()));
	}

	public boolean isRouteExist(Long sid) {
		return scheduleRouteRepository.exists(Integer.valueOf(sid.intValue()));
	}
	
	public void addTrain(TrainTO trainTo) {

		scheduleTrainRepository.save(trainTo);

	}
	
	public void addRoute(RouteTO routeTo) {

		scheduleRouteRepository.save(routeTo);

	}
}
