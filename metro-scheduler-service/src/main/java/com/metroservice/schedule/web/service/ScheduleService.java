package com.metroservice.schedule.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metroservice.schedule.data.entity.Schedule;
import com.metroservice.schedule.data.repository.ScheduleRepository;
import com.metroservice.schedule.exception.ScheduleNotFoundException;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public String sayHello() {
		return "Hello!";
	}

	public List<Schedule> getAllSchedules() {
		List<Schedule> schedules=new ArrayList<Schedule>();
		 scheduleRepository.findAll().forEach(schedules::add);
		 return schedules;
	}
	public void addSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
	}
	public Schedule getSchedule(Integer sid) {
		return scheduleRepository.findById(sid).orElseThrow(() -> new ScheduleNotFoundException("Schedule","Schedule_Id",sid));
	}
	
	public boolean isScheduleExist(Integer sid) {
		return scheduleRepository.findById(sid).isPresent();
	}
	
	public Schedule updateSchedule(Integer scheduleId,Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	
	public void deleteSchedule(Integer scheduleId) {
		scheduleRepository.deleteById(scheduleId);
	}

}
