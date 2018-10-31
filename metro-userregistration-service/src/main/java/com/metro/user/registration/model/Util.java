package com.metro.user.registration.model;

public class Util {
	//------------------------------------------------------------------------------------
	public static UserRegTO convertEntityToDTO(UserDetail entity) {
		UserRegTO to = new UserRegTO();
		to.setId              (entity.getId               ());
		to.setUsername        (entity.getUserName         ());
		to.setEmail           (entity.getEmail            ());
		to.setFirstName       (entity.getFirstName        ());
		to.setLastName        (entity.getLastName         ());
		to.setPassword        (entity.getPassword         ());
		//to.setRoles           (entity.getRoles            ());
		return to;
	}
	
	public static UserDetail convertDTOToEntity(UserRegTO to) {
		UserDetail entity = new UserDetail();
		entity.setId              (to.getId               ());
		entity.setUserName        (to.getUsername         ());
		entity.setEmail           (to.getEmail            ());
		entity.setFirstName       (to.getFirstName        ());
		entity.setLastName        (to.getLastName         ());
		entity.setPassword        (to.getPassword         ());
		//entity.setRoles           (to.getRoles            ());
		return entity;
	}

	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
}


