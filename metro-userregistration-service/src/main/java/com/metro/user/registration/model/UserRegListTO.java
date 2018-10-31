package com.metro.user.registration.model;

import java.util.ArrayList;
import java.util.List;

public class UserRegListTO {
	private List<UserRegTO> userRegList = new ArrayList<UserRegTO>();

	public List<UserRegTO> getUserRegList() {
		return userRegList;
	}

	public void setUserRegList(List<UserRegTO> userRegList) {
		this.userRegList = userRegList;
	}
}
