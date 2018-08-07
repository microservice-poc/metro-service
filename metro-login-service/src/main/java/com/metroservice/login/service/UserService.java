package com.metroservice.login.service;

import com.metroservice.login.entity.UserDetail;

public interface UserService {
	
	public UserDetail findByEmail(String userName);
	
	public void saveUser(UserDetail userDetail);

}
