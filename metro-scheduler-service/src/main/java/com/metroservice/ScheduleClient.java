package com.metroservice;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ScheduleClient {

	private HttpHeaders getHeaders() {
    	String credential="Gangadhar:g123";
    	//String credential="tarun:t123";
    	String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
     	headers.add("Authorization", "Basic " + encodedCredential);
    	return headers;
    }
	public void getScheduleByIdDemo() {
    	HttpHeaders headers = getHeaders();  
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8099/schedules";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class,  1);
        System.out.println(responseEntity.getBody());      
    }
	
	public static void main(String args[]) {
		ScheduleClient client = new ScheduleClient();
		client.getScheduleByIdDemo();
       /* util.getAllArticlesDemo();
    	//util.addArticleDemo();
    	util.updateArticleDemo();
    	//util.deleteArticleDemo();
*/    }   
	
}
