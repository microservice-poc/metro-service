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

import org.springframework.web.client.RestTemplate;

import com.metroservice.ui.business.domain.RouteTO;
import com.metroservice.ui.business.domain.RouteTOList;
import com.metroservice.ui.business.domain.StationTO;
import com.metroservice.ui.business.domain.StationTOList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

//@Getter @Setter 
@lombok.Data
@ManagedBean
@ViewScoped
public class RouteBean {

    private long   routeId             ;
    private String routeNumber         ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private Date   lastModifiedDate    ;
	private List<RouteTO> routeList = null;
	private Map<String, String> stationMap = null;
	private List<SelectItem> stationList;

    @PostConstruct
	public void getAllRoutes() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		//populate routes with dummy values
		//routeList = new ArrayList<RouteTO>();
		//for(int i=0;i<20;i++) {
		//	RouteTO rto = new RouteTO();
		//	rto.setRouteId(i);
		//	rto.setStartingStationId(100);
		//	routeList.add(rto);
		//}
		
        String uri = "";
        RouteTOList rtoList = null;
        StationTOList stationTOList = null;
        RestTemplate restTemplate = new RestTemplate();

		//------------------------------------------------------------------------------------
		//populate station list
       	uri = "http://localhost:8101/station/all";
        stationTOList = restTemplate.getForObject(uri, StationTOList.class);
		System.out.println("RouteBean.getAllStation() ************** = "+stationTOList);
		List<StationTO> stationList1 = stationTOList.getStationList();

		//populate station map for future lookup
		stationMap = new HashMap<String, String>();
		for(int i=0;i<stationList1.size();i++) {
			stationMap.put(""+stationList1.get(i).getStationId(), stationList1.get(i).getStationName()); 
		}

		//populate station list dropdown for UI
		stationList = new ArrayList<SelectItem>();
		for(int i=0;i<stationList1.size();i++) {
			SelectItem si = new SelectItem(stationList1.get(i).getStationId(), stationList1.get(i).getStationName());
			stationList.add(si); 
		}
		//------------------------------------------------------------------------------------
		//populate route list
       	uri = "http://localhost:8101/route/all";
        rtoList = restTemplate.getForObject(uri, RouteTOList.class);
		System.out.println("RouteBean.getAllRoutes() ************** = "+rtoList);
		routeList = rtoList.getRouteList();
		//now populate the station names for their Ids
		for(int i=0;i<routeList.size();i++) {
			RouteTO rto = routeList.get(i);
			long startingStationId = rto.getStartingStationId();
			String startingStationName = stationMap.get(""+startingStationId);
			rto.setStartingStationName(startingStationName);
			long endStationId = rto.getEndStationId();
			String endStationName = stationMap.get(""+endStationId);
			rto.setEndStationName(endStationName);
		}

		//------------------------------------------------------------------------------------


	}
    
    public void routeSaveAction() {
    	System.out.println(routeId             );
    	System.out.println(routeNumber         );
    	System.out.println(startingStationId   );
    	System.out.println(endStationId        );
        
		RouteTO routeTO = new RouteTO();
        routeTO.setRouteId(routeId);
        routeTO.setRouteNumber(routeNumber);
        routeTO.setStartingStationId(startingStationId);
        routeTO.setEndStationId(endStationId);
        
		RestTemplate restTemplate = new RestTemplate();
		RouteTO response = restTemplate.postForObject("http://localhost:8101/route/save/", routeTO, RouteTO.class);
		System.out.println("saveRoute="+response);

    }

    //--------------------------------------------------------------------------------
//	public List<RouteTO> getRouteList() {
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - getter");
//		return routeList;
//	}
//
//	public void setRouteList(List<RouteTO> routeList) {
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX - setter");
//
//		this.routeList = routeList;
//	}
//
//
//	public Map<String, String> getStationMap() {
//		return stationMap;
//	}
//
//	public void setStationMap(Map<String, String> stationMap) {
//		this.stationMap = stationMap;
//	}
//
//	public List<SelectItem> getStationList() {
//		return stationList;
//	}
//
//	public void setStationList(List<SelectItem> stationList) {
//		this.stationList = stationList;
//	}
//
//    //--------------------------------------------------------------------------------
//	public long getRouteId() {
//		return routeId;
//	}
//
//	public void setRouteId(long routeId) {
//		this.routeId = routeId;
//	}
//
//	public String getRouteNumber() {
//		return routeNumber;
//	}
//
//	public void setRouteNumber(String routeNumber) {
//		this.routeNumber = routeNumber;
//	}
//
//	public long getStartingStationId() {
//		return startingStationId;
//	}
//
//	public void setStartingStationId(long startingStationId) {
//		this.startingStationId = startingStationId;
//	}
//
//	public long getEndStationId() {
//		return endStationId;
//	}
//
//	public void setEndStationId(long endStationId) {
//		this.endStationId = endStationId;
//	}
//
//	public Date getLastModifiedDate() {
//		return lastModifiedDate;
//	}
//
//	public void setLastModifiedDate(Date lastModifiedDate) {
//		this.lastModifiedDate = lastModifiedDate;
//	}
}
