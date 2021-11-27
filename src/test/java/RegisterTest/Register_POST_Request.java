package RegisterTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Register_POST_Request extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	public int responseIdVal= 0;
	public String responseStringValue = "";
	
	@BeforeTest
	public void beforeTest() {
		
		//provide base uri
		RestAssured.baseURI="https://reqres.in";
		
		// create request object
		httpRequest = RestAssured.given();
		
		// create JSON Object for post request
		JSONObject requestparam = new JSONObject();
		requestparam.put("email","eve.holt@reqres.in");
		requestparam.put("password","pistol");
		
//		httpRequest.header("Content-Type","application/json");		
		httpRequest.body(requestparam.toJSONString());

		//create response object
		response = httpRequest.request(Method.POST,"/api/register");
		
		String responseVal = response.body().asString();
		System.out.println(responseVal);
		
	}
	
	@Test
	public void verifyStatusCode() {
		
		//validate status code value
		int statusCodeVal = response.getStatusCode();
		Assert.assertEquals(statusCodeVal,200);
	}
	
//	@Test
//	public void responseBodyValue() {
//		
//		// validate response body value
//		  int idValue = response.jsonPath().getInt("id");
//		  responseIdVal = response.jsonPath().getInt("id");
//		  Assert.assertEquals(idValue,responseIdVal);
//		  
//		  // validate generated token
//		  String tokenVal = response.jsonPath().getString("token");
//		  responseStringValue = response.jsonPath().getString("token");
//		  Assert.assertEquals(tokenVal,responseStringValue);
//	}
//	
	
}
