package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.requests.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * BaseService - A wrapper around Rest Assured for handling API requests
 */
public class BaseService {

	// Base URL for all API calls
	private static final String BASE_URL = "http://64.227.160.186:8080";
	
	// Common RequestSpecification to reuse across requests
	private RequestSpecification requestSpecification;
	
	// this block executes only once as we are using static so even if parallel execution used it will execute only once
	static{
		RestAssured.filters(new LoggingFilter());
	}

	// Constructor initializes request specification with base URI
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}

	/**
	 * POST request
	 * @param payLoad - Request body as object (will be serialized to JSON)
	 * @param endPoint - API endpoint to hit
	 * @return Response - Response returned from server
	 */
	protected Response postRequest(Object payLoad, String endPoint) {
		return requestSpecification
				.contentType(ContentType.JSON) // Set content type to JSON
				.body(payLoad) // Set request body
				.post(endPoint); // Send POST request
	}

	/**
	 * GET request
	 * @param endpoint - API endpoint to hit
	 * @return Response - Response returned from server
	 */
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint); // Send GET request
	}

	/**
	 * Set Authorization token in header
	 * @param token - Bearer token to set for authentication
	 */
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

	/**
	 * PUT request
	 * @param payLoad - Request body as object (will be serialized to JSON)
	 * @param endPoint - API endpoint to hit
	 * @return Response - Response returned from server
	 */
	protected Response putRequest(Object payLoad, String endPoint) {
		return requestSpecification
				.contentType(ContentType.JSON) // Set content type to JSON
				.body(payLoad) // Set request body
				.put(endPoint); // Send PUT request
	}
}
