package practise.RestAssured2;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Single_User_GET_Request extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void beforeRequest() {

		//initialize base URI
		RestAssured.baseURI="https://reqres.in";
		log.info("base uri is been provided");
		
		//create request specification object
		httpRequest = RestAssured.given();
		log.info("request object is been created");
		
		//create response object
		 response = httpRequest.request(Method.GET,"/api/users/2");
		log.info("response object is been created");
	}
	
	
	@Test
	public void verifyStatusCodeForRequest() {		
		//validate status code
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
		log.info("status code for request is:"+statusCodeVal);
	}
	
	
	@Test
	public void getBodyResponseForRequest() {
		
		Map<String, String> data = response.jsonPath().getMap("data");
		System.out.println(data.get("email"));
		Assert.assertEquals(data.get("email"),"janet.weaver@reqres.in");
	}
	
	
	@Test
	public void verifyHeaderForRequest() {
		
		//validate header for request
		String headerVal = response.header("Content-Type");
		Assert.assertEquals(headerVal,"application/json; charset=utf-8");
		log.info("content-type header value for request is:"+headerVal);
		
		String headerVal2 = response.header("Server");
		Assert.assertEquals(headerVal2,"cloudflare");
		log.info("server header value for request is:"+headerVal2);
	}
	
	
}
