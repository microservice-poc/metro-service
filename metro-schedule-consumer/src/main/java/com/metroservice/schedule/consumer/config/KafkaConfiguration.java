package com.metroservice.schedule.consumer.config;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.metroservice.schedule.consumer.model.RouteTO;
import com.metroservice.schedule.consumer.model.TrainTO;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Value("${kafka.producer.servers}")
	private String producerInstance;
	@Value("${route.group}")
	private String routeGroup;
	@Value("${train.group}")
	private String trainGroup;
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    @Bean
    public ConsumerFactory<String, RouteTO> routeConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, producerInstance);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, routeGroup);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                new JsonDeserializer<>(RouteTO.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RouteTO> routeKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RouteTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(routeConsumerFactory());
        return factory;
    }
    
    @Bean
	public ConsumerFactory<String, TrainTO> trainConsumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, producerInstance);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, trainGroup);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				JsonDeserializer.class);
		//configs.put(JsonDeserializer.TRUSTED_PACKAGES, "com.metroservice.schedule.data.entity");

		return new DefaultKafkaConsumerFactory<>(configs,new StringDeserializer(),new JsonDeserializer<>(TrainTO.class));
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TrainTO> trainKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, TrainTO> factory = new ConcurrentKafkaListenerContainerFactory<String, TrainTO>();
		factory.setConsumerFactory(trainConsumerFactory());
		return factory;

	}
	class CustomJsonDeserializer<T> extends JsonDeserializer<T> {
		public CustomJsonDeserializer() {
			// defaults from superclass
			super();

			// add our packages
			//this.addTrustedPackages("com.metroservice.schedule.data.entity");
		}
	}
	
}
