package com.metroservice.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MetroUIApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroUIApplication.class, args);
	}
}
