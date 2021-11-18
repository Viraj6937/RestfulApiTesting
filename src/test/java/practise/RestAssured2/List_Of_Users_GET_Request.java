package practise.RestAssured2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class List_Of_Users_GET_Request {
	
	
	@Test
	public void verifyStatusCodeForRequest() {
		
		// provide base URI
		RestAssured.baseURI="https://reqres.in";

		//create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//create response object
	    Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		System.out.println(response.body().asString());
		
		//validate response status code
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
		
	}
	
	@Test
	public void verifyResponseBodyValueForRequest() {

		// provide base URI
		RestAssured.baseURI="https://reqres.in";

		//create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//create response object
	    Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		System.out.println(response.body().asString());
		
	  //validate body value for request
	   System.out.println(response.body().asString());
	   
	   String responseBodyVal = response.jsonPath().getString("page");
	   
	   Assert.assertEquals(responseBodyVal,"2");
	
	}
	
	@Test
	public void verifyHeaderValueForRequest() {

		// provide base URI
		RestAssured.baseURI="https://reqres.in";

		//create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//create response object
	    Response response = httpRequest.request(Method.GET,"/api/users?page=2");
		System.out.println(response.body().asString());
		
		//validate Content-Type response header value
		String responseHeaderValue = response.getHeader("Content-Type");
		System.out.println("The response header value for content-type is:"+responseHeaderValue);
		Assert.assertEquals(responseHeaderValue,"application/json; charset=utf-8");
		
		//Validate Server response header value
		String responseHeaderValue2 = response.getHeader("Server");
		System.out.println("The response header value for server is:"+responseHeaderValue2);
		Assert.assertEquals(responseHeaderValue2, "cloudflare");
	}
	
}
