package practise.RestAssured2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Delete_User_Request extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void beforeRequest() {
		// create RestAssured uri
		RestAssured.baseURI="https://reqres.in";
		log.info("base uri is been created");
		
		// create request object
		httpRequest = RestAssured.given();
		log.info("request object is been created");
		
		//create response object
		response = httpRequest.request(Method.DELETE,"/api/users/2");
		log.info("response object is been created");
	}
	
	@Test
	public void verifyStatusCode() {
		// validate status code
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,204);
		log.info("status code for request is 204");
	}
	
	@Test
	public void verifyResponseBodyForDeleteRequest() {
		//validate response body value for request
		String responseBodyValue = response.body().asString();
		Assert.assertEquals(responseBodyValue,"");
	}
	
	
}
