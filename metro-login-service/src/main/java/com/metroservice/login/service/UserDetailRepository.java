package com.metroservice.login.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metroservice.login.entity.UserDetail;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Long>{
	
	UserDetail findByEmail(String email);
}
