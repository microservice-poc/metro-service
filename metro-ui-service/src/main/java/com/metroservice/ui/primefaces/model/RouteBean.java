package com.metroservice.ui.primefaces.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.metroservice.ui.business.domain.RouteTO;
import com.metroservice.ui.business.domain.RouteTOList;
import com.metroservice.ui.business.domain.StationTO;
import com.metroservice.ui.business.domain.StationTOList;
import com.metroservice.ui.business.domain.TrainTO;
import com.metroservice.ui.business.domain.TrainTOList;

//@Getter @Setter 
@lombok.Data
//@ManagedBean
@ViewScoped
@Controller
public class RouteBean extends SpringBeanAutowiringSupport{

	@Value("${APIGATEWAY.BASEURL}") //working because of @Controller
	private String apiGatewayBaseUrl;	
	
	public static final boolean USE_DUMMY_VALUES = false; 
	
	//RouteTO related
    private long   routeId             ;
    private String routeNumber         ;
    private long   startingStationId   ;
    private long   endStationId        ;
    private long   trainId             ;
    private Date   lastModifiedDate    ;

	//StationTO related
    private long   stationId             ;
    private String stationName           ;

	//TrainTO related
    //private long   trainId             ;
    //private String trainName           ;

    
    private List<RouteTO> routeList = null;
    private List<StationTO> stationList = null;
    private List<TrainTO> trainList = null;
	private Map<String, String> stationMap = null;
	private List<SelectItem> stationDropdownList;
	private List<SelectItem> trainDropdownList;

    @PostConstruct
	public void getAllRoutes() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
        String uri = "";
        RouteTOList routeTOList = new RouteTOList();
        StationTOList stationTOList = new StationTOList();
        TrainTOList trainTOList = new TrainTOList();
        
        if(USE_DUMMY_VALUES == true) {
        	populateDummyStationValues();
        	populateDummyRouteValues();
        	populateDummyTrainValues();
        	
        	routeTOList.setRouteList(routeList);
        	stationTOList.setStationList(stationList);
        	trainTOList.setTrainList(trainList);
    		populateModelVariables(routeTOList, stationTOList, trainTOList);
    		return;
        }
        RestTemplate restTemplate = new RestTemplate();

		//------------------------------------------------------------------------------------
		//populate station list (API gateway URL is being used here)
        
        System.out.println("apiGatewayBaseUrl="+apiGatewayBaseUrl);
        if(StringUtils.isEmpty(apiGatewayBaseUrl)) {
        	//apiGatewayBaseUrl = "http://localhost:8901";
        	return;
        }
       
       	uri = apiGatewayBaseUrl+"/station/all";
		System.out.println("RouteBean.before call to : "+uri);
        stationTOList = restTemplate.getForObject(uri, StationTOList.class);

		//------------------------------------------------------------------------------------
		//populate route list (API gateway URL is being used here)
		if(StringUtils.isEmpty(apiGatewayBaseUrl)) {
        	//apiGatewayBaseUrl = "http://localhost:8901";
        	return;
        }
       	uri = apiGatewayBaseUrl+"/route/all";
		System.out.println("RouteBean.before call to : "+uri);
        routeTOList = restTemplate.getForObject(uri, RouteTOList.class);

		//------------------------------------------------------------------------------------
		//populate train list (API gateway URL is being used here)
		if(StringUtils.isEmpty(apiGatewayBaseUrl)) {
        	//apiGatewayBaseUrl = "http://localhost:8901";
        	return;
        }
       	uri = apiGatewayBaseUrl+"/trains";
		System.out.println("RouteBean.before call to : "+uri);
		trainTOList = restTemplate.getForObject(uri, TrainTOList.class);


		//------------------------------------------------------------------------------------
		populateModelVariables(routeTOList, stationTOList, trainTOList);
	}

    //************************************************************************************
	public void populateModelVariables(RouteTOList routeTOList, StationTOList stationTOList, TrainTOList trainTOList ) {
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYY");


		System.out.println("RouteBean.getAllStation().count() ************** = "+stationTOList);
		System.out.println("RouteBean.getAllStation().count() ************** = "+stationTOList.getStationList());
		System.out.println("RouteBean.getAllStation().count() ************** = "+stationTOList.getStationList().size());
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
		System.out.println("RouteBean.getAllRoutes().count() ************** = "+routeTOList);
		System.out.println("RouteBean.getAllRoutes().count() ************** = "+routeTOList.getRouteList());
		System.out.println("RouteBean.getAllRoutes().count() ************** = "+routeTOList.getRouteList().size());
		routeList = routeTOList.getRouteList();
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
		System.out.println("RouteBean.trains.count= ************** = "+trainTOList);
		System.out.println("RouteBean.trains.count= ************** = "+trainTOList.getTrainList());
		System.out.println("RouteBean.trains.count= ************** = "+trainTOList.getTrainList().size());
		if(trainTOList != null) {
			trainList = trainTOList.getTrainList();
		}
		
		//populate train list dropdown for UI
		trainDropdownList = new ArrayList<SelectItem>();
		if(trainList != null) {
			for(int i=0;i<trainList.size();i++) {
				SelectItem si = new SelectItem(trainList.get(i).getTrainId(), trainList.get(i).getTrainNumber() + " - " + trainList.get(i).getTrainName());
				trainDropdownList.add(si); 
			}
		}
		

		//------------------------------------------------------------------------------------
	}

    //************************************************************************************
    public void routeSaveAction() {
    	System.out.println(routeId             );
    	System.out.println(routeNumber         );
    	System.out.println(startingStationId   );
    	System.out.println(endStationId        );
        System.out.println("apiGatewayBaseUrl="+apiGatewayBaseUrl);
        if(apiGatewayBaseUrl == null) {
        	return;
        }
        
		RouteTO routeTO = new RouteTO();
        routeTO.setRouteId(routeId);
        routeTO.setRouteNumber(routeNumber);
        routeTO.setStartingStationId(startingStationId);
        routeTO.setEndStationId(endStationId);
        
		RestTemplate restTemplate = new RestTemplate();
        // (API gateway URL is being used here)
		RouteTO response = restTemplate.postForObject(apiGatewayBaseUrl+"/route/save/", routeTO, RouteTO.class);
		System.out.println("saveRoute="+response);

    }
    //************************************************************************************
    public void stationSaveAction() {
    	System.out.println(stationId             );
    	System.out.println(stationName           );
        System.out.println("apiGatewayBaseUrl="+apiGatewayBaseUrl);
        if(apiGatewayBaseUrl == null) {
        	return;
        }

		StationTO stationTO = new StationTO();
        stationTO.setStationId(stationId);
        stationTO.setStationName(stationName);
        
		RestTemplate restTemplate = new RestTemplate();
        // (API gateway URL is being used here)
		StationTO response = restTemplate.postForObject(apiGatewayBaseUrl+"/station/save/", stationTO, StationTO.class);
		System.out.println("saveStation="+response);
    }
    //************************************************************************************
    public void populateDummyRouteValues() {
    	routeList = new ArrayList();

    	RouteTO rto = null;
    	rto = new RouteTO(); rto.setRouteId(1); rto.setRouteNumber("100"); rto.setLastModifiedDate(new Date()); rto.setStartingStationId(1);  rto.setEndStationId(2);  routeList.add(rto);
    	rto = new RouteTO(); rto.setRouteId(2); rto.setRouteNumber("200"); rto.setLastModifiedDate(new Date()); rto.setStartingStationId(2);  rto.setEndStationId(3);  routeList.add(rto);
    	rto = new RouteTO(); rto.setRouteId(3); rto.setRouteNumber("300"); rto.setLastModifiedDate(new Date()); rto.setStartingStationId(3);  rto.setEndStationId(4);  routeList.add(rto);
    	rto = new RouteTO(); rto.setRouteId(4); rto.setRouteNumber("400"); rto.setLastModifiedDate(new Date()); rto.setStartingStationId(4);  rto.setEndStationId(1);  routeList.add(rto);
    	
		for(int i=0;i<routeList.size();i++) {
			RouteTO rto1 = routeList.get(i);
			long startingStationId = rto1.getStartingStationId();
			String startingStationName = stationMap.get(""+startingStationId);
			rto1.setStartingStationName(startingStationName);
			long endStationId = rto1.getEndStationId();
			String endStationName = stationMap.get(""+endStationId);
			rto1.setEndStationName(endStationName);
		}
    	
    }
    //************************************************************************************
    public void populateDummyStationValues() {
    	stationList = new ArrayList();

    	StationTO sto = null;
    	sto = new StationTO();      sto.setStationId(1);    	sto.setStationName("Majestic"); sto.setLastModifiedDate(new Date()); stationList.add(sto);
    	sto = new StationTO();      sto.setStationId(2);    	sto.setStationName("KRPuram");  sto.setLastModifiedDate(new Date()); stationList.add(sto);
    	sto = new StationTO();      sto.setStationId(3);    	sto.setStationName("ITPL");    	sto.setLastModifiedDate(new Date()); stationList.add(sto);
    	sto = new StationTO();      sto.setStationId(4);    	sto.setStationName("BEML");    	sto.setLastModifiedDate(new Date()); stationList.add(sto);
    	
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
    	
    }
    //************************************************************************************
    public void populateDummyTrainValues() {
    	trainList = new ArrayList();
    	TrainTO rto = null;
    	rto = new TrainTO();      rto.setTrainId(1);    	rto.setTrainName("Shatabdi"); 		rto.setLastModifiedDate(new Date()); trainList.add(rto);
    	rto = new TrainTO();      rto.setTrainId(2);    	rto.setTrainName("Gharib Rath");	rto.setLastModifiedDate(new Date()); trainList.add(rto);
    	rto = new TrainTO();      rto.setTrainId(3);    	rto.setTrainName("Bangalore Exp");  rto.setLastModifiedDate(new Date()); trainList.add(rto);
    	rto = new TrainTO();      rto.setTrainId(4);    	rto.setTrainName("Mysore Exp");    	rto.setLastModifiedDate(new Date()); trainList.add(rto);

    	//populate train list dropdown for UI
		trainDropdownList = new ArrayList<SelectItem>();
		if(trainList != null) {
			for(int i=0;i<trainList.size();i++) {
				SelectItem si = new SelectItem(trainList.get(i).getTrainId(), trainList.get(i).getTrainNumber() + " - " + trainList.get(i).getTrainName());
				trainDropdownList.add(si); 
			}
		}
    }

    //************************************************************************************
}
