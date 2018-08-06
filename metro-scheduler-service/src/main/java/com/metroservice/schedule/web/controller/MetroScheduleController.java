package com.metroservice.schedule.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metroservice.schedule.data.entity.Schedule;
import com.metroservice.schedule.web.service.ScheduleService;

@RestController
public class MetroScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("/hello")
	public String sayHello() {
		return scheduleService.sayHello();

	}

	@GetMapping("/schedules")
	public List<Schedule> getAllSchedules() {
		return scheduleService.getAllSchedules();

	}

	@PostMapping("/schedules")
	public void addSchedule(@Valid @RequestBody Schedule schedule) {
		boolean isExist = scheduleService.isScheduleExist(schedule.getScheduleId());
		if(!isExist){
		scheduleService.addSchedule(schedule);
		}
	}

	@PutMapping("/schedules/{id}")
	public Schedule updateSchedule(
			@PathVariable(value = "id") Integer scheduleId,
			@Valid @RequestBody Schedule scheduleDetails) {

		scheduleService.getSchedule(scheduleId);
		return scheduleService.updateSchedule(scheduleId, scheduleDetails);
	}

	@DeleteMapping("/schedules/{id}")
	public ResponseEntity<?> deleteSchedule(
			@PathVariable(value = "id") Integer scheduleId) {
		Schedule schedule = scheduleService.getSchedule(scheduleId);
		scheduleService.deleteSchedule(schedule.getScheduleId());

		return ResponseEntity.ok().build();
	}
}
