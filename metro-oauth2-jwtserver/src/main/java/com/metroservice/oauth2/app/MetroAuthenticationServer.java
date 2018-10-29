package com.metroservice.oauth2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class MetroAuthenticationServer {

	public static void main(String[] args) {
		SpringApplication.run(MetroAuthenticationServer.class, args);
	}
}
