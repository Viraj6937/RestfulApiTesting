package practise.RestAssured2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Create_User_POST_Request extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	public int responseId = 0;
	
	@BeforeTest
	public void beforeRequest() {
		
		// Create RestAssured base uri
		RestAssured.baseURI="https://reqres.in";
		log.info("base uri is been provided");
		
		//create request object
		httpRequest = RestAssured.given();
		log.info("request object is been created");
		
		//create JSON Object to pass value in request
		 JSONObject requestparam = new JSONObject();
		 requestparam.put("name","Viraj");
		 requestparam.put("job", "Software Test Engineer");
		 httpRequest.header("Content-Type","application/json; charset=utf-8");
		
		//create response object
		response = httpRequest.request(Method.POST,"/api/users");
		log.info("response object is been created");
	}
	
	@Test
	public void verifyStatusCodeForPostRequest() {
		//validate status code
		int statusVal = response.getStatusCode();
		Assert.assertEquals(statusVal,201);	
		log.info("status code for request is been validated");
	}
	
	@Test
	public void verifyResponseBodyForPostRequest() {
		//validate response body value
		int responseIdVal = response.jsonPath().getInt("id");
		responseId = response.jsonPath().getInt("id");
		Assert.assertEquals(responseIdVal,responseId);
		log.info("response body for post request is"+responseId);
	}
	
	@Test
	public void verifyHeaderValueForPostRequest() {
		//validate header value
		String headerValue = response.header("Content-Type");
		Assert.assertEquals(headerValue, "application/json; charset=utf-8");
		log.info("header value for post request is"+headerValue);
	}
}
