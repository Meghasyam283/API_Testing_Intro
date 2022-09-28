package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	@Test
	void googleMapTest()
	{
		//sepcify base URI
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml....");
		
		//print response in console
		String responseBody=response.getBody().toString();
		System.out.println("Response body "+responseBody);
		
		//launch the postman tool and see what are trhe headers the api is returning
		//Capture details of headers from response
		
		String contentType=response.header("Content-Type");//Cpature details of Content-Type
		System.out.println("Content-Type :"+contentType);
		Assert.assertEquals(contentType,"application/xml; charset=UTF-8");
		
		String contentEncoding=response.header("Content-Encoding");//Cpature details of Content-Encoding
		System.out.println("Content-Encoding :"+contentEncoding);
		Assert.assertEquals(contentEncoding,"gzip");
	}

}
