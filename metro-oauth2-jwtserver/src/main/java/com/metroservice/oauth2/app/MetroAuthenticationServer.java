package com.metroservice.oauth2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAutoConfiguration()
@EnableResourceServer
public class MetroAuthenticationServer {

	public static void main(String[] args) {
		SpringApplication.run(MetroAuthenticationServer.class, args);
	}
}
