package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request_ValidatingJSONResponse {
	@Test
	public void getWeatherDetails()
	{
			//sepcify base URI
			RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
					
			//Request object
			RequestSpecification httpRequest=RestAssured.given();
					
			//Response object
			Response response=httpRequest.request(Method.GET,"Delhi");
					
			//print response in console
			String responseBody=response.getBody().toString();
			System.out.println("Response body "+responseBody);
			
			//THis will tell whether the Json contains Delhi or not
			Assert.assertEquals(responseBody.contains("Delhi"),true);
					
	}
}
