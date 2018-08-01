package com.metroservice.route.web.service;

import com.metroservice.route.business.domain.RouteTO;
import com.metroservice.route.business.service.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RouteServiceController.class)
public class RouteServiceControllerTest {

    @MockBean
    private RouteService routeService;
    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

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
    }
}
