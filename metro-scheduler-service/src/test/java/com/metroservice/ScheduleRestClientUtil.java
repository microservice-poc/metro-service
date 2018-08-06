package com.metroservice;

import java.util.Calendar;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.metroservice.schedule.data.entity.Schedule;

public class ScheduleRestClientUtil {
	public static void main(String args[]) {
		ScheduleRestClientUtil client = new ScheduleRestClientUtil();
		//client.getAllSchedules();
		//client.sayHello();
		client.addScheduleDemo();
		//client.updateScheduleDemo();
		//client.deleteScheduleDemo();
		System.out.println("=====================================");
		client.getAllSchedules();
	}

	private void getAllSchedules() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8099/schedules";
        HttpEntity<Schedule> requestEntity = new HttpEntity<Schedule>(headers);
        ResponseEntity<Schedule[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Schedule[].class);
        Schedule[] schedules = responseEntity.getBody();
        for(Schedule schedule : schedules) {
              System.out.println(schedule);
        }
	}
        
        public void sayHello() {
    		HttpHeaders headers = new HttpHeaders();
    		headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
    	    String url = "http://localhost:8099/hello";
            HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            System.out.println(responseEntity.getBody());
            
	}
        
        public void addScheduleDemo() {
        	HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
    	    String url = "http://localhost:8099/schedules";
    	    Schedule objSchedule = new Schedule();
    	    objSchedule.setScheduleId(9);
    	    objSchedule.setRouteId(0);
    	    objSchedule.setTrainId(0);
    	    Calendar startTime=Calendar.getInstance();
    	    startTime.set(2018, 8, 04, 8, 30);
    	    Calendar endTime=Calendar.getInstance();
    	    endTime.set(2018, 8, 04, 20, 30);
    	    objSchedule.setStartTime(startTime.getTime());
    	    objSchedule.setEndTime(endTime.getTime());
            HttpEntity<Schedule> requestEntity = new HttpEntity<Schedule>(objSchedule, headers);
            restTemplate.postForLocation(url, requestEntity);
        }
        public void deleteScheduleDemo() {
        	HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
    	    String url = "http://localhost:8099/schedules/9";
            HttpEntity<Schedule> requestEntity = new HttpEntity<Schedule>(headers);
            restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 9);        
        }
        
        public void updateScheduleDemo() {
        	HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
    	    String url = "http://localhost:8099/schedules/9";
    	    Schedule objSchedule = new Schedule();
    	    objSchedule.setScheduleId(9);
    	    objSchedule.setRouteId(2);
    	    objSchedule.setTrainId(3);
    	    Calendar startTime=Calendar.getInstance();
    	    startTime.set(2018, 8, 04, 8, 30);
    	    Calendar endTime=Calendar.getInstance();
    	    endTime.set(2018, 8, 04, 20, 30);
    	    objSchedule.setStartTime(startTime.getTime());
    	    objSchedule.setEndTime(endTime.getTime());
            HttpEntity<Schedule> requestEntity = new HttpEntity<Schedule>(objSchedule, headers);
            restTemplate.put(url, requestEntity);
        }
}
