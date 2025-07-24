package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // here we are doing static import so that we dont need to write RestAssured again and again as all the methods and variables are static from this class
// so we dont need to write class name again and again and we can directly used the RestAssured methods and variable also by doing so we can increase the redability of the code

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Listeners(com.api.listners.TestListener.class)
public class LoginAPITest2 {

	@Test(description = "Verify if ogin API is working....")
	public void loginTest() {


		Response response =given()
				.baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
				.body("{\"username\":\"Arti\",\"password\":\"Test1234\"}")
				.post("/api/auth/login");

		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
