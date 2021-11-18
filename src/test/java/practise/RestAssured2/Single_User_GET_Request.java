package practise.RestAssured2;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Single_User_GET_Request {

	
	@Test
	public void verifyStatusCodeForRequest() {
		//initialize base URI
		RestAssured.baseURI="https://reqres.in";
		
		//create request specification object
		RequestSpecification httpRequest = RestAssured.given();
		
		//create response object
		Response response = httpRequest.request(Method.GET,"/api/users/2");
		
		//validate status code
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
	}
	
	@Test
	public void verifyHeaderForRequest() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/api/users/2");
		
		//validate header for request
		String headerVal = response.header("Content-Type");
		Assert.assertEquals(headerVal,"application/json; charset=utf-8");
		
		String headerVal2 = response.header("Server");
		Assert.assertEquals(headerVal2,"cloudflare");
		
	}
	
}
