package com.metro.user.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metro.user.registration.dao.UserDetailRepository;
import com.metro.user.registration.model.UserDetail;
import com.metro.user.registration.model.UserRegTO;
import com.metro.user.registration.model.Util;

@RestController
//@RequestMapping("/register")
public class UserRegistrationManager {

	@Autowired
	private UserDetailRepository repo;

	//----------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.POST, value="/register/save")
	public UserRegTO create(@RequestBody UserRegTO user) {
        System.out.println("Inside User registration controller POST");
        UserDetail entity = Util.convertDTOToEntity(user);
        UserDetail returnEntity = repo.save(entity);
        return Util.convertEntityToDTO(returnEntity);
	}
	//----------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(method= RequestMethod.GET, value="/register/all")
	public void get() {
        System.out.println("Inside User registration controller GET");
	}
	//----------------------------------------------------------------------------------------------------------------------------------
}
