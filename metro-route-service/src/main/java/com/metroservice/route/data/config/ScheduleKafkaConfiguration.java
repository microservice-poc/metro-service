package com.metroservice.route.data.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.data.entity.Route;


@EnableKafka
@Configuration
public class ScheduleKafkaConfiguration {

	@Value("${kafka.producer.servers}")
	private String producerInstance;

	@Bean
	public ProducerFactory<String, RouteTO> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerInstance);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, RouteTO>(config);
	}

	@Bean
	public KafkaTemplate<String, RouteTO> kafkaTemplate() {
		return new KafkaTemplate<String, RouteTO>(producerFactory());
	}

}
