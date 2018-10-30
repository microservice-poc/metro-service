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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.metroservice.ui.business.domain.UserRegTO;
import com.metroservice.ui.business.domain.UserRegTOList;

//@Getter @Setter 
@lombok.Data
//@ManagedBean
@ViewScoped
@Controller
public class UserRegBean extends SpringBeanAutowiringSupport{

	@Value("${APIGATEWAY.BASEURL}") //working because of @Controller
	private String apiGatewayBaseUrl;	
	
	public static final boolean USE_DUMMY_VALUES = true; 
	
    private int    userId;
    private String userName;
    private String email;
    private String gender;

    
    private List<UserRegTO> userRegList = null;

    @PostConstruct
	public void getAllData() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
        String uri = "";
        UserRegTOList userRegTOList = new UserRegTOList();

        
        if(USE_DUMMY_VALUES == true) {
        	userRegTOList = populateDummyUserValues();
    		populateModelVariables(userRegTOList);
    		return;
        }
        RestTemplate restTemplate = new RestTemplate();
		//------------------------------------------------------------------------------------
		//populate station list (API gateway URL is being used here)
        
        System.out.println("apiGatewayBaseUrl="+apiGatewayBaseUrl);
        if(StringUtils.isEmpty(apiGatewayBaseUrl)) {
        	return;
        }
       
       	uri = apiGatewayBaseUrl+"/register/all";
		System.out.println("UserRegBean.before call to : "+uri);
		userRegTOList = restTemplate.getForObject(uri, UserRegTOList.class);

		//------------------------------------------------------------------------------------
		populateModelVariables(userRegTOList);
	}

    //************************************************************************************
	public void populateModelVariables(UserRegTOList userRegTOList ) {
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYY");


		System.out.println("UserRegBean..populateModelVariables().count() ************** = "+userRegTOList);
		System.out.println("UserRegBean..populateModelVariables().count() ************** = "+userRegTOList.getUserRegList());
		System.out.println("UserRegBean..populateModelVariables() ************** = "+userRegTOList.getUserRegList().size());
		userRegList = userRegTOList.getUserRegList();
		//------------------------------------------------------------------------------------
	}

    //************************************************************************************
    public void userRegSaveAction() {
    	System.out.println("Entering UserRegBean.userRegSaveAction()");
    	System.out.println(userId             );
    	System.out.println(userName           );
    	System.out.println(email              );
    	System.out.println(gender             );
    	
        System.out.println("apiGatewayBaseUrl="+apiGatewayBaseUrl);
        
        if(apiGatewayBaseUrl == null) {
        	return;
        }
        
		UserRegTO userTO = new UserRegTO();
        userTO.setId(0L);
        userTO.setName(userName);
        userTO.setEmail(email);
        userTO.setPassword("1234");
        
		RestTemplate restTemplate = new RestTemplate();
        // (API gateway URL is being used here)
		String finalURL = apiGatewayBaseUrl+"/register/save/";
		System.out.println("finalURL="+finalURL);
		UserRegTO response = restTemplate.postForObject(finalURL, userTO, UserRegTO.class);
		System.out.println("saveUser="+response);

    }
    //************************************************************************************

    //************************************************************************************
    public UserRegTOList populateDummyUserValues() {
    	UserRegTOList listTO = new UserRegTOList(); 
    	userRegList = new ArrayList<UserRegTO>();
    	UserRegTO rto = null;
    	rto = new UserRegTO();      rto.setId(1L);    	rto.setName("Shib"); rto.setLastModifiedDate(new Date()); userRegList.add(rto);
    	rto = new UserRegTO();      rto.setId(2L);    	rto.setName("Guru"); rto.setLastModifiedDate(new Date()); userRegList.add(rto);
    	rto = new UserRegTO();      rto.setId(3L);    	rto.setName("Ravi"); rto.setLastModifiedDate(new Date()); userRegList.add(rto);
    	rto = new UserRegTO();      rto.setId(4L);    	rto.setName("Kris"); rto.setLastModifiedDate(new Date()); userRegList.add(rto);
    	listTO.setUserRegList(userRegList);
    	return listTO;
    }

    //************************************************************************************
}
