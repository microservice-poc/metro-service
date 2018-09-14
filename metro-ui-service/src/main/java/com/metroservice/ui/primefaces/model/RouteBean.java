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

	//RouteTO related
    private long   routeId             ;
    private String routeNumber         ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private Date   lastModifiedDate    ;

	//StationTO related
    private long   stationId             ;
    private String stationName           ;

    
    private List<RouteTO> routeList = null;
    private List<StationTO> stationList = null;
	private Map<String, String> stationMap = null;
	private List<SelectItem> stationDropdownList;

    @PostConstruct
	public void getAllRoutes() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
        String uri = "";
        RouteTOList rtoList = null;
        StationTOList stationTOList = null;
        RestTemplate restTemplate = new RestTemplate();

		//------------------------------------------------------------------------------------
		//populate station list (API gateway URL is being used here)
       	uri = "http://localhost:8901/station/all";
		System.out.println("RouteBean.before call to : "+uri);
        stationTOList = restTemplate.getForObject(uri, StationTOList.class);
		System.out.println("RouteBean.getAllStation() ************** = "+stationTOList);
		stationList = stationTOList.getStationList();

		//populate station map for future lookup
		stationMap = new HashMap<String, String>();
		for(int i=0;i<stationList.size();i++) {
			stationMap.put(""+stationList.get(i).getStationId(), stationList.get(i).getStationName()); 
		}

		//populate station list dropdown for UI
		stationDropdownList = new ArrayList<SelectItem>();
		for(int i=0;i<stationList.size();i++) {
			SelectItem si = new SelectItem(stationList.get(i).getStationId(), stationList.get(i).getStationName());
			stationDropdownList.add(si); 
		}
		//------------------------------------------------------------------------------------
		//populate route list (API gateway URL is being used here)
       	uri = "http://localhost:8901/route/all";
		System.out.println("RouteBean.before call to : "+uri);
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

    //************************************************************************************
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
        // (API gateway URL is being used here)
		RouteTO response = restTemplate.postForObject("http://localhost:8901/route/save/", routeTO, RouteTO.class);
		System.out.println("saveRoute="+response);

    }
    //************************************************************************************
    public void stationSaveAction() {
    	System.out.println(stationId             );
    	System.out.println(stationName           );
        
		StationTO stationTO = new StationTO();
        stationTO.setStationId(stationId);
        stationTO.setStationName(stationName);
        
		RestTemplate restTemplate = new RestTemplate();
        // (API gateway URL is being used here)
		StationTO response = restTemplate.postForObject("http://localhost:8901/station/save/", stationTO, StationTO.class);
		System.out.println("saveStation="+response);
    }
    //************************************************************************************
}
