package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;
@Listeners(com.api.listners.TestListener.class)
public class GetProfileRequestTest {

	
	@Test(description = "Verify if Get Profile API is working....")
	public void getProfileInfor()
	{
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Arti","Test1234"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("Received Token is : "+ loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response= userProfileManagementService.getProfile(loginResponse.getToken());
		
		System.out.println("Get Profile Response ----- "+response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		
	}
}
