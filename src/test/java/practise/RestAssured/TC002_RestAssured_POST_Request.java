package practise.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_RestAssured_POST_Request {

	@Test
	public void getRestAssuredPostRequest() {
		
		// initialize base uri
		RestAssured.baseURI="https://reqres.in";
		
		//create request
		RequestSpecification httprequest = RestAssured.given();
		
		// Json Object
		  
		  JSONObject requestparam = new JSONObject();
		  requestparam.put("name","Viraj");
		  requestparam.put("job","Software Test Engineer");
		  
		  httprequest.header("Content-Type","application/json");
		  
		  httprequest.body(requestparam.toJSONString());
		  
		  
		 Response response = httprequest.request(Method.POST,"/api/users");
		 
		 //response body
		 String responseBodyVal = response.getBody().asString();
		 System.out.println("the value is"+responseBodyVal);
		 
		 //response body value validate
		 String responseBodyVal2 = response.jsonPath().get("name");
		 Assert.assertEquals(responseBodyVal2,"Viraj");
		 
		 
		 
		
	}
	
	
}
