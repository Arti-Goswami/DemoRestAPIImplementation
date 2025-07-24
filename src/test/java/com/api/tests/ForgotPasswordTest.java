package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;
@Listeners(com.api.listners.TestListener.class)
public class ForgotPasswordTest {

	@Test(description = "Verify if Password API is working....")
	public void createAccountTest() {

		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("arti1.goswami@gmail.com");
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "If your email exists in our system, you will receive reset instructions.");
		Assert.assertEquals(response.statusCode(), 200);

	}

}
