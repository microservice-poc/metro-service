package com.metroservice.ui.primefaces.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.metroservice.ui.business.domain.RouteTO;
import com.metroservice.ui.business.domain.StationTO;

@ManagedBean
@ViewScoped
public class RouteBean {

    private long   routeId             ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private Date   lastModifiedDate    ;
	private List<RouteTO> routeList = null;
	private Map<String, String> stationMap = null;
	private List<SelectItem> stationList;

    @PostConstruct
	public void getAllRoutes() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		//populate route list
		routeList = new ArrayList<RouteTO>();
		for(int i=0;i<20;i++) {
			RouteTO rto = new RouteTO();
			rto.setRouteId(i);
			rto.setStartingStationId(100);
			routeList.add(rto);
		}

		//populate station map
		stationMap = new HashMap<String, String>();
		for(int i=0;i<20;i++) {
			stationMap.put(""+i, "Station"+i);
		}

		//populate station list
		stationList = new ArrayList<SelectItem>();
		for(int i=0;i<20;i++) {
			SelectItem si = new SelectItem(""+i, "Station "+i);
			stationList.add(si); 
		}


	}
    
    public void routeSaveAction() {
    	System.out.println(routeId             );
    	System.out.println(startingStationId   );
    	System.out.println(endStationId        );
    }

    //--------------------------------------------------------------------------------
	public List<RouteTO> getRouteList() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - getter");
		return routeList;
	}

	public void setRouteList(List<RouteTO> routeList) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - setter");

		this.routeList = routeList;
	}


	public Map<String, String> getStationMap() {
		return stationMap;
	}

	public void setStationMap(Map<String, String> stationMap) {
		this.stationMap = stationMap;
	}

	public List<SelectItem> getStationList() {
		return stationList;
	}

	public void setStationList(List<SelectItem> stationList) {
		this.stationList = stationList;
	}

    //--------------------------------------------------------------------------------
	public long getRouteId() {
		return routeId;
	}

	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}

	public long getStartingStationId() {
		return startingStationId;
	}

	public void setStartingStationId(long startingStationId) {
		this.startingStationId = startingStationId;
	}

	public long getEndStationId() {
		return endStationId;
	}

	public void setEndStationId(long endStationId) {
		this.endStationId = endStationId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
