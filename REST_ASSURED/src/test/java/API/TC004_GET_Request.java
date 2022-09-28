package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request {
	@Test
	public void GetWeatherDetails()
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
				
				Headers allHeaders=response.headers();//Cpature all Headers from response
				
				for(Header header : allHeaders)
				{
					System.out.println(header.getName()+" :"+header.getValue());
					System.out.println();

				}
	}

}
//In response we can verify status code, status line, 
//ResponseTime and sometimes ResponseBody
