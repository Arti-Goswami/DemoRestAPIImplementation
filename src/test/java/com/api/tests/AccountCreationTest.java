package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

@Listeners(com.api.listners.TestListener.class)
public class AccountCreationTest {

	@Test(description = "Verify if Account Creation is working....")
	public void createAccountTest() {

		SignUpRequest signUpReq =new SignUpRequest.Builder().userName("Arti")
				.email("artigoswami87@mgail.com")
				.firstName("Arti")
				.lastName("Goswami")
				.mobileNumber(987888787)
				.password(null)
				.build();

		// Builder design pattern helps to write any parameter anywhere, we are not bound to remember sequence for the parameters
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpReq);
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);

	}

}
