package API;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	@Test
	void getweatherDetails()
	{
		//sepcify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in console
		String responseBody=response.getBody().toString();
		System.out.println("Response body "+responseBody);
		
		//sataus code validaton
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line validation
		String statusline=response.getStatusLine();
		System.out.println("Status line :"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
	}

}
