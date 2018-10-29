package com.metroservice.schedule.consumer.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.metroservice.schedule.consumer.model.RouteTO;
import com.metroservice.schedule.consumer.model.TrainTO;
import com.metroservice.schedule.consumer.service.ScheduleConsumerService;

@Service
public class KafkaConsumer {

	@Autowired
	private ScheduleConsumerService scheduleConsumerService;
	
	@KafkaListener(topics = "Kafka_Example", group = "group_id")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}

	@KafkaListener(topics = "train_topic", group = "train_group", containerFactory = "trainKafkaListenerFactory")
	public void consumeJson(TrainTO trainTo) {
		System.out.println("Train Consumed JSON Message: " + trainTo);
		scheduleConsumerService.addTrain(trainTo);
	}
	@KafkaListener(topics = "route_topic", group = "route_group", containerFactory = "routeKafkaListenerFactory")
	public void consume(RouteTO routeTo) {
		System.out.println("The Route is " + routeTo);
		scheduleConsumerService.addRoute(routeTo);
	}
}
