package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.data.entity.Route;
import com.metroservice.route.business.service.RouteService;
import com.metroservice.route.data.repository.RouteRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.json.JacksonTester;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.ExitCodeGenerator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import com.metroservice.route.RoutesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RouteServiceController.class)
//@DataJpaTest
public class RouteServiceControllerTest {

    @MockBean
    private RouteService routeService;
    //@Autowired
    //private RouteRepository routeRepository;
    @Autowired 
    private ObjectMapper objectMapper;
    
    ConfigurableApplicationContext ctx;
	//-------------------------------------------------------------------------------------------
    @Before
    public void setup() {
		System.out.println("**********************************************************************************************");
		System.out.println("------------------- Starting RoutesApplication for JUnit testing -----------------------------");
		System.out.println("**********************************************************************************************");
		ctx = SpringApplication.run(RoutesApplication.class, new String[]{});
    }
	//-------------------------------------------------------------------------------------------
    @After
    public void destroy() {
		System.out.println("**********************************************************************************************");
		System.out.println("-------------------- Stopping RoutesApplication for JUnit testing ----------------------------");
		System.out.println("**********************************************************************************************");
        int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                    return 0;
                }
        });
    }
	//-------------------------------------------------------------------------------------------
    @Test
    public void getRoutes() throws Exception{
        
        String uri = "";
        RouteTO routeTO = null;
        RestTemplate restTemplate = new RestTemplate();

       	uri = "http://localhost:8100/route/1";
        routeTO = restTemplate.getForObject(uri, RouteTO.class);
		System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
	
       	uri = "http://localhost:8100/route/2";
        routeTO = restTemplate.getForObject(uri, RouteTO.class);
		System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
	
       	uri = "http://localhost:8100/route/3";
        routeTO = restTemplate.getForObject(uri, RouteTO.class);
		System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
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
		//System.out.println("routeRepository="+routeRepository);
		//Route route = routeRepository.findOne((long)3);
		//System.out.println("route="+route);
		
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
