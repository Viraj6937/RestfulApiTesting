package practise.RestAssured2;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Single_User_Not_Found_GET_Request extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void beforeRequest(){
		// create base url
		RestAssured.baseURI="https://reqres.in";
		
		// create request object
		httpRequest = RestAssured.given();
		
		//create response object
		response = httpRequest.request(Method.GET,"/api/users/23");
	}
	
	@Test
	public void verifyStatusCodeForRequest() {
		//validate status code as 404
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,404);
	}
	
	@Test
	public void verifyResponseBodyForRequest() {
	   //validate response body
	   String responseVal = response.body().asString();
	   System.out.println(responseVal);
	   Assert.assertEquals(response.body().asString(),"{}");
	}

}
