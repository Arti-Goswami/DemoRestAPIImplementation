package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.BaseService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest extends BaseService{
	
	
	@Test(description = "Verify if Update Profile is working....")
	public void updateProfileTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Arti", "Test1234"));
		System.out.println("Login Request Response is : "+response.asPrettyString());
		System.out.println("-------------------------------------------------------------------");
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println("Received Token is : "+ loginResponse.getToken());

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response= userProfileManagementService.getProfile(loginResponse.getToken());
		
		System.out.println("Get Profile Response ----- "+response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		Assert.assertEquals(userProfileResponse.getUsername(),"Arti");
		System.out.println("-------------------------------------------------------------------");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Arti1")
				.lastName("Goswami1")
				.email("arti1.goswami@gmail.com")
				.mobileNumber("3456678623")
				.build();
		
		response= userProfileManagementService.updateProfile(loginResponse.getToken(),profileRequest );
		System.out.println("Put Profile Response ----- "+response.asPrettyString());
		System.out.println("-------------------------------------------------------------------");
		
	}
}
