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

import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import com.metroservice.route.RoutesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RouteServiceController.class)
public class RouteServiceControllerTest {

    @MockBean
    private RouteService routeService;
    //@Autowired
    //private RouteRepository  routeRepository;
    @Autowired 
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    private JacksonTester<RouteTO> jsonTester;
    
    org.springframework.context.ConfigurableApplicationContext ctx;
    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	//-------------------------------------------------------------------------------------------
    @Before
    public void setup() {
        JacksonTester.initFields(this, objectMapper);
        
		ctx = SpringApplication.run(RoutesApplication.class, new String[]{});
        
    }
	//-------------------------------------------------------------------------------------------
    @After
    public void destroy() {
        int exitCode = SpringApplication.exit(ctx, new org.springframework.boot.ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                    // return the error code
                    return 0;
                }
        });
    }
	//-------------------------------------------------------------------------------------------
    @Test
    public void getRoutes() throws Exception{
        Date date = DATE_FORMAT.parse("2017-01-01");
        List<RouteTO> mockRouteList = new ArrayList<>();
        RouteTO mockRoute = new RouteTO();
        mockRoute.setRouteId(1);
        //mockRoute.setRouteName("Shibu");
        //mockRoute.setDate(date);
        //mockRoute.setGuestId(1);
        //mockRoute.setRoomNumber("J1");
        //mockRoute.setRoomId(100);
        //mockRoute.setRoomName("JUnit Room");
        mockRouteList.add(mockRoute);

		System.out.println("Shibu1 *****************************************************************");
        //given(routeService.getRoutesForDate("2017-01-01")).willReturn(mockRouteList);
        //this.mockMvc.perform(get("/route/date=2017-01-01")).andExpect(status().isOk()).andExpect(content().string(containsString("Shibu")));
        
        
		//org.springframework.context.ConfigurableApplicationContext ctx = SpringApplication.run(RoutesApplication.class, new String[]{});
        
        String uri = "";
        RouteTO routeTO = null;
        RestTemplate restTemplate = new RestTemplate();

       	uri = "http://localhost:8101/route/1";
        routeTO = restTemplate.getForObject(uri, RouteTO.class);
		System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
	
       	uri = "http://localhost:8101/route/2";
        routeTO = restTemplate.getForObject(uri, RouteTO.class);
		System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
	
       	uri = "http://localhost:8101/route/3";
        routeTO = restTemplate.getForObject(uri, RouteTO.class);
		System.out.println("RouteServiceControllerTest.getRoutes() ************** = "+routeTO);
        
        
        //int exitCode = SpringApplication.exit(ctx, new org.springframework.boot.ExitCodeGenerator() {
        //    @Override
        //    public int getExitCode() {
        //            // return the error code
        //            return 0;
        //        }
        //});

    }
	//-------------------------------------------------------------------------------------------
    @Test
    public void saveRoute() throws Exception {
        RouteTO routeTO = new RouteTO();
        routeTO.setRouteId(1001);
        routeTO.setStartingStationId(9997);
        //final String routeDTOJson = jsonTester.write(routeTO).getJson();

        
        
        
		//org.springframework.context.ConfigurableApplicationContext ctx = SpringApplication.run(RoutesApplication.class, new String[]{});
        
        
        
		RestTemplate restTemplate = new RestTemplate();
		RouteTO response = restTemplate.postForObject("http://localhost:8101/route/save/", routeTO, RouteTO.class);
		System.out.println("saveRoute="+response);
        
        
        
        
        
        //int exitCode = SpringApplication.exit(ctx, new org.springframework.boot.ExitCodeGenerator() {
        //    @Override
        //    public int getExitCode() {
        //            // return the error code
        //            return 0;
        //        }
        //});
        
        
        
        
       //mockMvc
       //    .perform(post("/route/save").content(routeDTOJson).contentType(APPLICATION_JSON_UTF8))
       //    .andExpect(status().isCreated());
       ////verify(routeRepository).persist(any(Route.class));
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
