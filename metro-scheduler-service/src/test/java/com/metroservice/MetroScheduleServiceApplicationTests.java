package com.metroservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metroservice.schedule.data.entity.Schedule;
import com.metroservice.schedule.web.service.ScheduleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetroScheduleServiceApplicationTests {

	@Autowired
	private ScheduleService scheduleService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSayHello(){
		
		assertEquals("Hello!",scheduleService.sayHello());
	}
	@Test
	public void testAllSchedules(){
		
		assertTrue(scheduleService.getAllSchedules().size()>0);
	}
	@Test
	public void testAddSchedule() {
		Schedule objSchedule = new Schedule();
	    objSchedule.setScheduleId(9);
	    objSchedule.setRouteId(5);
	    objSchedule.setTrainId(6);
	    Calendar startTime=Calendar.getInstance();
	    startTime.set(2018, 8, 04, 8, 30);
	    Calendar endTime=Calendar.getInstance();
	    endTime.set(2018, 8, 04, 20, 30);
	    objSchedule.setStartTime(startTime.getTime());
	    objSchedule.setEndTime(endTime.getTime());
	    boolean isExist = scheduleService.isScheduleExist(objSchedule.getScheduleId());
		if(!isExist){
		scheduleService.addSchedule(objSchedule);
		}
	}
	@Test
	public void testUpdateSchedule() {
		Schedule objSchedule = new Schedule();
	    objSchedule.setScheduleId(7);
	    objSchedule.setRouteId(2);
	    objSchedule.setTrainId(3);
	    Calendar startTime=Calendar.getInstance();
	    startTime.set(2018, 8, 04, 8, 30);
	    Calendar endTime=Calendar.getInstance();
	    endTime.set(2018, 8, 04, 20, 30);
	    objSchedule.setStartTime(startTime.getTime());
	    objSchedule.setEndTime(endTime.getTime());
	    Schedule upSchedule=scheduleService.updateSchedule(7, objSchedule);
	    assertEquals(objSchedule.getTrainId(), upSchedule.getTrainId());
	}
	
	@Test
	public void testDeleteSchedule(){
		if(scheduleService.isScheduleExist(4)){
		scheduleService.deleteSchedule(4);
		}
		assertEquals(false,scheduleService.isScheduleExist(4));
		
	}
}