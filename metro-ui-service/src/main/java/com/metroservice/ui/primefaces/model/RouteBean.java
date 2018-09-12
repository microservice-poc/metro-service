package com.metroservice.ui.primefaces.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.metroservice.ui.business.domain.RouteTO;

@ManagedBean
@ViewScoped
public class RouteBean {

	static {
		//getAllRoutes();
	}
	private List<RouteTO> routeList = null;

    @PostConstruct
	public void getAllRoutes() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		List<RouteTO> returnList = new ArrayList<RouteTO>();
		for(int i=0;i<20;i++) {
			RouteTO rto = new RouteTO();
			rto.setRouteId(i);
			rto.setStartingStationId(100);
			returnList.add(rto);
		}

		routeList = returnList;
	}

	public List<RouteTO> getRouteList() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - getter");
		return routeList;
	}

	public void setRouteList(List<RouteTO> routeList) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - setter");

		this.routeList = routeList;
	}
}
