package com.metroservice.train.web.service;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.metroservice.train.TrainApplication;
import com.metroservice.train.business.domain.TrainTO;
import com.metroservice.train.business.service.TrainService;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(TrainServiceController.class)
public class TrainServiceControllerTest {

    //@MockBean
    //private TrainService trainService;
    
    //@Autowired 
    //private ObjectMapper objectMapper;
    
    //ConfigurableApplicationContext ctx;
	
    //@Before
    //public void setup() {
	//	ctx = SpringApplication.run(TrainApplication.class, new String[]{});
    //}
	//
    //@After
    //public void destroy() {
	//    int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
    //        @Override
    //        public int getExitCode() {
    //                return 0;
    //            }
    //    });
    //}
	
    @Test
    public void getTrainByTrainNumber() throws Exception{
        //String uri = "";
        //TrainTO trainTO = null;
        //RestTemplate restTemplate = new RestTemplate();
        //
       	//uri = "http://localhost:8200/train/500010";
       	//trainTO = restTemplate.getForObject(uri, TrainTO.class);
		//System.out.println("TrainServiceControllerTest.getTrainByTrainNumber() ******11111111111******** = "+trainTO);
	    //
       	//uri = "http://localhost:8200/train/500011";
       	//trainTO = restTemplate.getForObject(uri, TrainTO.class);
		//System.out.println("TrainServiceControllerTest.getTrainByTrainNumber() *****22222222222222********* = "+trainTO);
	
    }
    
	
    @Test
    public void addTrain() throws Exception {
       
       //TrainTO trainTO = new TrainTO();
       //trainTO.setTrainName("Local Train1");
       //trainTO.setTrainNumber(500016);
       //trainTO.setLastServicedDate(new Date());
       //
       //
	   //RestTemplate restTemplate = new RestTemplate();
	   //TrainTO response = restTemplate.postForObject("http://localhost:8200/train/add/", trainTO, TrainTO.class);
	   //System.out.println("saveTrain3333333333333333333333="+response);
		
    }
	
}
