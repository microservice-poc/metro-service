package com.metroservice.metroconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MetroConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroConfigApplication.class, args);
	}
}
