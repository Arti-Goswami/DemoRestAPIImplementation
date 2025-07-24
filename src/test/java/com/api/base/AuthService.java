package com.api.base;

import java.util.HashMap;

import com.api.models.requests.LoginRequest;
import com.api.models.requests.SignUpRequest;



import io.restassured.response.Response;

public class AuthService extends BaseService {
	private static final String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest payload) {
		return postRequest(payload,BASE_PATH+"login");
	}

	
	public Response signUp(SignUpRequest payload) {
		return postRequest(payload,BASE_PATH+"signup");
	}
	
	
	public Response forgotPassword(String emailAddress) {
		// we are not creating anyPOJO class for forgot password as we only need one value i.e. Email Address 
		// to make sure that our payload object has both key and value pair we have created HashMap
		// and in that HashMap we are adding key As Email, and value as users email ID
		// and that HashMap we are adding as payload
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", emailAddress);
		return postRequest(payload,BASE_PATH+"forgot-password");
	} 
}
