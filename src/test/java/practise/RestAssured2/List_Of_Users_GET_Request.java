package practise.RestAssured2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class List_Of_Users_GET_Request extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void beforeRequest() {
		
	    // provide base URI
	    RestAssured.baseURI="https://reqres.in";
	    
	    log.info("base uri is been provided");
		
		//create request object
		httpRequest = RestAssured.given();
		
		log.info("request object is been created");
		
		//create response object
	    response = httpRequest.request(Method.GET,"/api/users?page=2");
         log.info("response object is been created");
	    System.out.println(response.body().asString());

		
	}
	
	
	@Test
	public void verifyStatusCodeForRequest() {
				
		//validate response status code
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
		log.info("the status code for request is:"+statusCodeVal);
	}
	
	@Test
	public void verifyResponseBodyValueForRequest() {

	   //validate body value for request
	   System.out.println(response.body().asString());
	   
	   String responseBodyVal = response.jsonPath().getString("page");
	   
	   Assert.assertEquals(responseBodyVal,"2");
	   
	   log.info("response body value for request is:"+responseBodyVal);
	
	}
	
	@Test
	public void verifyHeaderValueForRequest() {

        System.out.println(response.body().asString());
	
		//validate Content-Type response header value
		String responseHeaderValue = response.getHeader("Content-Type");
		System.out.println("The response header value for content-type is:"+responseHeaderValue);
		Assert.assertEquals(responseHeaderValue,"application/json; charset=utf-8");
		log.info("content-type response header value for request is:"+responseHeaderValue);
		
		//Validate Server response header value
		String responseHeaderValue2 = response.getHeader("Server");
		System.out.println("The response header value for server is:"+responseHeaderValue2);
		Assert.assertEquals(responseHeaderValue2, "cloudflare");
		log.info("server header value for request is"+responseHeaderValue2);
	}
	
}
