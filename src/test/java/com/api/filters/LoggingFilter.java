package com.api.filters;


import org.apache.logging.log4j.LogManager;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{

//	
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec,responseSpec);// Request is going to executed ahead
				logResponse(response);
		return response; // taken to the test for the assertion
	}

	public void logRequest(FilterableRequestSpecification requestSpec)
	{
		logger.info("BASE URI :"+ requestSpec.getBaseUri());
		logger.info("Request Header :"+ requestSpec.getHeaders());
		logger.info("Request Body /Payload :"+ requestSpec.getBody());
	}

	public void logResponse(Response response)
	{
		logger.info("Status Code :"+ response.getStatusCode());
		logger.info("Request Body / Payload :"+ response.headers());
		logger.info("Request Header :"+ response.getBody().prettyPrint());
	}

	
}
