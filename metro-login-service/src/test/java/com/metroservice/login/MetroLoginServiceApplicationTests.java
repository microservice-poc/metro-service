package com.metroservice.login;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.metroservice.login.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginRestController.class, secure = false)
public class MetroLoginServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserServiceImpl loginService;
	
	String expectedString = "ACTIVE";

	@Test
	public void validateUser() throws Exception {

		//Mockito.when(loginService.checkValidUser(Mockito.anyString(), Mockito.anyString()))
				//.thenReturn("ACTIVE");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/login/admin/admin")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		
		assertEquals(expectedString, result.getResponse()
				.getContentAsString());

	}

}
