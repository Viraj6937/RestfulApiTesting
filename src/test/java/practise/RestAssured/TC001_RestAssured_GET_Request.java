package practise.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_RestAssured_GET_Request {

	
	@Test
	public void validateGetRequestForBooks() {
		
		// define base uri
		RestAssured.baseURI = "http://ip.jsontest.com";
		
		// request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		
		Response response = httpRequest.request(Method.GET,"/details");
		
		
		//print get request response body
		
		String responseBody = response.getBody().asString();
		
		System.out.println("The response body:"+responseBody);
		
		//validate the status code for get request
		
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
		
		
		//validate response body value
		String responseBodyVal = response.jsonPath().get("ip");
		Assert.assertEquals(responseBodyVal,"103.58.152.204");
				
	}
	
	
}
