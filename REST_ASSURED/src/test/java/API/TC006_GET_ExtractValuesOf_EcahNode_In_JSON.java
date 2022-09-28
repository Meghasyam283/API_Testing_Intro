package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class TC006_GET_ExtractValuesOf_EcahNode_In_JSON {
	public void getWeatherDetails()
	{
			//sepcify base URI
			RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
					
			//Request object
			RequestSpecification httpRequest=RestAssured.given();
					
			//Response object
			Response response=httpRequest.request(Method.GET,"Delhi");
					
			//If u want to extract each and every value in the object we have to use JSON PATH class
			JsonPath jsonpath=response.jsonPath();
			System.out.println(jsonpath.get("City"));
			System.out.println(jsonpath.get("Temperature"));
			System.out.println(jsonpath.get("Humidity"));
			System.out.println(jsonpath.get("WeatherDescription"));
			System.out.println(jsonpath.get("WindSpeed"));
			System.out.println(jsonpath.get("WindDirectionDegree"));
				
			Assert.assertEquals(jsonpath.get("Temperature"), "39 Degree celsius");
			
	}

}
