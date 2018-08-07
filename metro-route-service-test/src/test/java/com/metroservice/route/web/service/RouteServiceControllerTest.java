package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.data.entity.Route;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import com.metroservice.route.RoutesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
public class RouteServiceControllerTest {

	//-------------------------------------------------------------------------------------------
    @Test
    public void getRoutes() throws Exception{
        
        //String uri = "";
        //RouteTO routeTO = null;
        //RestTemplate restTemplate = new RestTemplate();
        //
       	//uri = "http://localhost:8100/route/1";
        //routeTO = restTemplate.getForObject(uri, RouteTO.class);
		//System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
	    //
       	//uri = "http://localhost:8100/route/2";
        //routeTO = restTemplate.getForObject(uri, RouteTO.class);
		//System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
	    //
       	//uri = "http://localhost:8100/route/3";
        //routeTO = restTemplate.getForObject(uri, RouteTO.class);
		//System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
    }
	//-------------------------------------------------------------------------------------------
    @Test
    public void saveRoute() throws Exception {
        RouteTO routeTO = new RouteTO();
        routeTO.setRouteId(1001);
        routeTO.setStartingStationId(9997);
        
		RestTemplate restTemplate = new RestTemplate();
		RouteTO response = restTemplate.postForObject("http://localhost:8100/route/save/", routeTO, RouteTO.class);
		System.out.println("saveRoute="+response);
    }
	//-------------------------------------------------------------------------------------------
    public RouteTO saveOneRoute() throws Exception {
        RouteTO routeTO = new RouteTO();
        routeTO.setRouteId(1001);
        routeTO.setStartingStationId(9997);
        
		RestTemplate restTemplate = new RestTemplate();
		RouteTO response = restTemplate.postForObject("http://localhost:8100/route/save/", routeTO, RouteTO.class);
		System.out.println("saveRoute="+response);
        return response;
    }
	//-------------------------------------------------------------------------------------------
    @Test
    public void deleteRoute() throws Exception {
        RouteTO to = saveOneRoute();
        long id = to.getRouteId();
        
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8100/route/"+id);
		System.out.println("deleteRoute complete");
    }
	//-------------------------------------------------------------------------------------------
    @Test
    public void deleteAllRoutes() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8100/route/deleteAll");
		System.out.println("deleteAllRoutes complete");
    }
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
}
