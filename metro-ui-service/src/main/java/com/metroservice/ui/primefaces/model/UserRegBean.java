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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.metroservice.ui.business.domain.RouteTO;
import com.metroservice.ui.business.domain.RouteTOList;
import com.metroservice.ui.business.domain.StationTO;
import com.metroservice.ui.business.domain.StationTOList;
import com.metroservice.ui.business.domain.TrainTO;
import com.metroservice.ui.business.domain.TrainTOList;
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
        	populateDummyUserValues();
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
       
       	uri = apiGatewayBaseUrl+"/user/all";
		System.out.println("RouteBean.before call to : "+uri);
		userRegTOList = restTemplate.getForObject(uri, UserRegTOList.class);

		//------------------------------------------------------------------------------------
		populateModelVariables(userRegTOList);
	}

    //************************************************************************************
	public void populateModelVariables(UserRegTOList userRegTOList ) {
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYY");


		System.out.println("RouteBean.getAllStation().count() ************** = "+userRegTOList);
		System.out.println("RouteBean.getAllStation().count() ************** = "+userRegTOList.getUserRegList());
		System.out.println("RouteBean.getAllStation().count() ************** = "+userRegTOList.getUserRegList().size());
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
        userTO.setUserId(userId);
        userTO.setUserName(userName);
        userTO.setEmail(email);
        userTO.setGender(gender);
        
		RestTemplate restTemplate = new RestTemplate();
        // (API gateway URL is being used here)
		String finalURL = apiGatewayBaseUrl+"/register/save/";
		System.out.println("finalURL="+finalURL);
		UserRegTO response = restTemplate.postForObject(finalURL, userTO, UserRegTO.class);
		System.out.println("saveUser="+response);

    }
    //************************************************************************************

    //************************************************************************************
    public void populateDummyUserValues() {
//    	trainList = new ArrayList();
//    	TrainTO rto = null;
//    	rto = new TrainTO();      rto.setTrainId(1);    	rto.setTrainName("Shatabdi"); 		rto.setLastModifiedDate(new Date()); trainList.add(rto);
//    	rto = new TrainTO();      rto.setTrainId(2);    	rto.setTrainName("Gharib Rath");	rto.setLastModifiedDate(new Date()); trainList.add(rto);
//    	rto = new TrainTO();      rto.setTrainId(3);    	rto.setTrainName("Bangalore Exp");  rto.setLastModifiedDate(new Date()); trainList.add(rto);
//    	rto = new TrainTO();      rto.setTrainId(4);    	rto.setTrainName("Mysore Exp");    	rto.setLastModifiedDate(new Date()); trainList.add(rto);
//
//    	//populate train list dropdown for UI
//		trainDropdownList = new ArrayList<SelectItem>();
//		if(trainList != null) {
//			for(int i=0;i<trainList.size();i++) {
//				SelectItem si = new SelectItem(trainList.get(i).getTrainId(), trainList.get(i).getTrainNumber() + " - " + trainList.get(i).getTrainName());
//				trainDropdownList.add(si); 
//			}
//		}
    }

    //************************************************************************************
}
