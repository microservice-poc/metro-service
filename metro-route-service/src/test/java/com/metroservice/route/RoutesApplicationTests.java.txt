package com.metroservice.route;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.metroservice.route.web.service.RouteServiceController;


@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(RouteServiceController.class)
public class RoutesApplicationTests {
//	@Autowired
//	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}

}
