package com.metroservice.login.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.metroservice.login.entity.Role;
import com.metroservice.login.entity.UserDetail;

@Service
public class UserServiceImpl implements UserService{
	
    @Autowired
    UserDetailRepository userDetailRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetail findByEmail(String userName) {
		return userDetailRepository.findByEmail(userName);
	}

	@Override
	public void saveUser(UserDetail userDetail) {
		String password = userDetail.getPassword();
		System.out.println("password :" + password);
		password = bCryptPasswordEncoder.encode(userDetail.getPassword());
		System.out.println("encrypted Password :" + password);
		userDetail.setPassword(password);
		userDetail.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        userDetail.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
        userDetailRepository.save(userDetail);		
	}


}
