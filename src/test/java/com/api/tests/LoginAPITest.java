package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Listeners(com.api.listners.TestListener.class)
public class LoginAPITest {

	@Test(description = "Verify if Login API is working....")
	public void loginTest() {

		RestAssured.baseURI = "http://64.227.160.186:8080";

		RequestSpecification x = RestAssured.given();

		RequestSpecification y = x.header("Content-Type", "application/json");

		RequestSpecification z = y.body("{\"username\":\"Arti\",\"password\":\"Test1234\"}");

		Response response = z.post("/api/auth/login");

		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
