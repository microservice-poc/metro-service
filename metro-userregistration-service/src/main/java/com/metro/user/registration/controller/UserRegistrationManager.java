package com.metro.user.registration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metro.user.registration.dao.UserDetailRepository;
import com.metro.user.registration.model.UserDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
@RequestMapping("/register")
public class UserRegistrationManager {

	@Autowired
	   private UserDetailRepository repo;
	
	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public UserDetail create(@RequestBody UserDetail user) {
		//Preconditions.checkNotNull(user);
		return repo.save(user);
	}
}
