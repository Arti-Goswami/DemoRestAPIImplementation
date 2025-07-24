package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*; 
// here we are doing static import so that we don't need to write RestAssured again and again as all the methods and variables are static from this class
// so we don't need to write class name again and again and we can directly used the RestAssured methods and variable also by doing so we can increase the redability of the code

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listners.TestListener.class)
public class LoginSuccessTest {

	@Test(description = "Verify if Login API is working....")
	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest("Arti", "Test1234");
		AuthService authService= new AuthService();

		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);

		
		  System.out.println(loginResponse.getToken());
		  System.out.println(loginResponse.getEmail());
		  System.out.println(loginResponse.getId());
		  System.out.println(loginResponse.getType());
		  System.out.println(loginResponse.getUsername());
		  System.out.println(loginResponse.getRoles());
		  System.out.println(response.asPrettyString());
		  
		  
		  Assert.assertTrue(loginResponse.getToken()!=null);
		  Assert.assertEquals(loginResponse.getEmail(),"arti1.goswami@gmail.com");
		  Assert.assertEquals(loginResponse.getId(),138);
		 
	}

}
