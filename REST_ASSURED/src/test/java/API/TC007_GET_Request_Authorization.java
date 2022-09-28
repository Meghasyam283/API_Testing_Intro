package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request_Authorization {
@Test
	public void Autherization()
	{
	//sepcify base URI
			RestAssured.baseURI="http://restapi.demoqa.com/authenticaton/checkForAuthentication";
			
			// Authentcation should be specified before the request sent
			PreemptiveBasicAuthScheme auth= new PreemptiveBasicAuthScheme();
			auth.setUserName("ToolsQA");
			auth.setPassword("TestPassword");
			
			RestAssured.authentication=auth;
			
			//Request object
			RequestSpecification httpRequest=RestAssured.given();
			
			//Response object
			Response response=httpRequest.request(Method.GET,"/");
			
			//sataus code validaton
			int statusCode = response.getStatusCode();
			System.out.println("Status code is :"+statusCode);
			Assert.assertEquals(statusCode, 200);
			
			//print response in console
			String responseBody=response.getBody().toString();
			System.out.println("Response body "+responseBody);
			
	}
	

}
//define BAserURI
//request Object
//Response Object
//Response Body
//validations-----
//Status code
//ResponseTime
//Staus line
//Headers(Content_type,Content....)

