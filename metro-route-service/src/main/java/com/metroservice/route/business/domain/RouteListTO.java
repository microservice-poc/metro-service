package com.metroservice.route.business.domain;

import java.util.ArrayList;
import java.util.List;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

//@Getter @Setter 
@Data
public class RouteListTO {
	private List<RouteTO> routeList = new ArrayList<RouteTO>();
}
