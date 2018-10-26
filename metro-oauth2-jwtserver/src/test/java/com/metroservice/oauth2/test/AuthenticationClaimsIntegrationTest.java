package com.metroservice.oauth2.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.metroservice.oauth2.app.MetroAuthenticationServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

@RunWith(SpringRunner.class)
@SpringBootTest(
  classes = MetroAuthenticationServer.class, 
  webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationClaimsIntegrationTest {
 
	private JwtTokenStore tokenStore;
 
    @Test
    public void whenTokenDoesNotContainIssuer_thenSuccess() {
        String tokenValue = obtainAccessToken("fooClientIdPassword", "john");
        System.out.println(tokenValue);
        tokenStore = new JwtTokenStore(accessTokenConverter());
        OAuth2Authentication auth = tokenStore.readAuthentication(tokenValue);
        Map<String, Object> details = (Map<String, Object>) auth.getDetails();
  
        assertTrue(details.containsKey("organization"));
    }
    
    @Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    KeyStoreKeyFactory keyStoreKeyFactory = 
	      new KeyStoreKeyFactory(new ClassPathResource("mytest.jks"), "mypass".toCharArray());
	    converter.setKeyPair(keyStoreKeyFactory.getKeyPair("mytest"));
	    return converter;
	}
 
    private String obtainAccessToken(
      String clientId, String username) {
  
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", "123");
        Response response = RestAssured.given()
          .auth().basic(clientId, "secret")
          .and().with().params(params).when()
          .post("http://localhost:8900/spring-security-oauth-server/login");
        System.out.println(response);
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        return response.jsonPath().getString("access_token");
    }
    
    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
