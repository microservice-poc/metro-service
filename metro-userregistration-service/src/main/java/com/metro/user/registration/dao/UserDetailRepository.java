package com.metro.user.registration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.metro.user.registration.model.UserDetail;

public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {
	List<UserDetail> findByEmail(String userid);
}
