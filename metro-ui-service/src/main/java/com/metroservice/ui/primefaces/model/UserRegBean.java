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
import com.metroservice.ui.business.domain.UserRegListTO;

//@Getter @Setter 
@lombok.Data
//@ManagedBean
@ViewScoped
@Controller
public class UserRegBean extends SpringBeanAutowiringSupport{

	@Value("${APIGATEWAY.BASEURL}") //working because of @Controller
	private String apiGatewayBaseUrl;	
	
	public static final boolean USE_DUMMY_VALUES = false; 
	
    private int    userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;

    
    private List<UserRegTO> userRegList = new ArrayList<>();

    @PostConstruct
	public void getAllData() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
        String uri = "";
        UserRegListTO userRegListTO = new UserRegListTO();

        if(USE_DUMMY_VALUES == true) {
        	userRegListTO = populateDummyUserValues();
    		populateModelVariables(userRegListTO);
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
		userRegListTO = restTemplate.getForObject(uri, UserRegListTO.class);

		//------------------------------------------------------------------------------------
		populateModelVariables(userRegListTO);
	}

    //************************************************************************************
	public void populateModelVariables(UserRegListTO userRegListTO ) {
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYY");

		try {
		System.out.println("UserRegBean..populateModelVariables().count() ************** = "+userRegListTO);
		System.out.println("UserRegBean..populateModelVariables().count() ************** = "+userRegListTO.getUserRegList());
		//System.out.println("UserRegBean..populateModelVariables() ************** = "+userRegListTO.getUserRegList().size());
		userRegList = userRegListTO.getUserRegList();
		} catch(Exception e) {
			//e.printStackTrace();
		}
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
        userTO.setUsername(userName);
        userTO.setEmail(email);
        userTO.setPassword(password);
        userTO.setFirstName(firstName);
        userTO.setLastName(lastName);
        
        
		RestTemplate restTemplate = new RestTemplate();
        // (API gateway URL is being used here)
		String finalURL = apiGatewayBaseUrl+"/register/save/";
		System.out.println("finalURL="+finalURL);
		UserRegTO response = restTemplate.postForObject(finalURL, userTO, UserRegTO.class);
		System.out.println("saveUser="+response);

    }
    //************************************************************************************

    //************************************************************************************
    public UserRegListTO populateDummyUserValues() {
    	UserRegListTO listTO = new UserRegListTO(); 
    	userRegList = new ArrayList<UserRegTO>();
    	UserRegTO userto = null;
    	userto = new UserRegTO(); userto.setId(1L); userto.setFirstName("Shib"); userto.setLastName("Shib"); userto.setEmail("Shib@oracle.com"); userto.setLastModifiedDate(new Date()); userRegList.add(userto);
    	userto = new UserRegTO(); userto.setId(2L); userto.setFirstName("Guru"); userto.setLastName("Guru"); userto.setEmail("Guru@oracle.com"); userto.setLastModifiedDate(new Date()); userRegList.add(userto);
    	userto = new UserRegTO(); userto.setId(3L); userto.setFirstName("Ravi"); userto.setLastName("Ravi"); userto.setEmail("Ravi@oracle.com"); userto.setLastModifiedDate(new Date()); userRegList.add(userto);
    	userto = new UserRegTO(); userto.setId(4L); userto.setFirstName("Kris"); userto.setLastName("Kris"); userto.setEmail("Kris@oracle.com"); userto.setLastModifiedDate(new Date()); userRegList.add(userto);
    	listTO.setUserRegList(userRegList);
    	return listTO;
    }

    //************************************************************************************
}
