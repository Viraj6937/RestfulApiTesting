package practise.RestAssured2;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;


public class List_Resources_GET_Request extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void beforeRequest() {
		// put base uri
		RestAssured.baseURI="https://reqres.in";
		
		// create request object
		httpRequest = RestAssured.given();
		
		//create response object
		response= httpRequest.request(Method.GET,"/api/unknown");
	}
	
	@Test
	public void verifyStatusCodeForRequest() {
		
		//validate status code
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
	}
	
	@Test
	public void verifyResponseBodyForRequest() {
		
		//validate response body
		Map<String,String> data = response.jsonPath().getMap("data[0]");
		Assert.assertEquals(data.get("name"),"cerulean");
		
	}
	
	
}
