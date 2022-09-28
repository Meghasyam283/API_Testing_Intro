package API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	void getweatherDetails()
	{
		//sepcify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/cutomer";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		//Request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("FirstName", "Raaamxyz");
		requestParams.put("LastName", "Raaamxyz");
		requestParams.put("User name", "Raaamxyz");
		requestParams.put("Password", "Raaamxyz");
		requestParams.put("Email", "Raaamxyz@gmail.com");
		
		httpRequest.header("Content-Type","application/json");// attach above to the request
		httpRequest.body(requestParams.toJSONString());
		
		
		Response response=httpRequest.request(Method.POST,"/register");
		
		
		//print response in console
		String responseBody=response.getBody().toString();
		System.out.println("Response body "+responseBody);
		
		//sataus code validaton
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :"+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Status line validation
		String statusline=response.getStatusLine();
		System.out.println("Status line :"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		//success code validation
		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "Operattion Sucess");
	}

}
