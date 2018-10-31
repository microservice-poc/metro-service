package com.metroservice.ui.business.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class UserRegListTO {
	private List<UserRegTO> userRegList = new ArrayList<UserRegTO>();
}
