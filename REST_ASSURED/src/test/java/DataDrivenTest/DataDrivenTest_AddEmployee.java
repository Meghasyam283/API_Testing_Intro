package DataDrivenTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddEmployee {
	
	@Test
	void postNewEmployee(String ename, String eage, String esal)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		
		// Creating data to send along with POST request
		JSONObject requestParams=new JSONObject();
		requestParams.put("name","ename");
		requestParams.put("salary","esal");
		requestParams.put("age","eage");
		
		//This will say thet above data is in JSON format
		httpRequest.header("Content-Type","application/json");
		
		//Add JSON body to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST request
		Response response = httpRequest.request(Method.POST,"/create");
		
		System.out.println("Ressponse Body: "+response);
		//capture response body to veriify the validation
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("ename"),true);
		Assert.assertEquals(responseBody.contains("esal"),true);
		Assert.assertEquals(responseBody.contains("esal"),true);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@DataProvider(name="empdataProvider")
	String[][] getEmpData()
	{
		//We are doing this data retrieval from Excel instead of hard-coding this data
//		String path="ExcelsheetPath";
		//or
		String path=System.getProperty("user.dir")+"/src/test/java,DataDrivenTest/emp.xls";
//		int rows = XLUtils.getRowCount(path,"sheet1");
//		int cols = XLUtils.getCellCount(path,"sheet1");
//		String empData[][]=new String[rows][cols];
//		for ( int i = 1 ; i < = rownum ; i ++ ) {
//		    for ( int j = 0 ; j < colcount ; j ++ ) {
//		   empdata [ i - 1 ] [ j ] = XLUtils.getCell Data ( path , " Sheet1 " , i , j ) ; I
//		    }
//		}
//		     
		//Hard coding the values
		String empData[][]= {{"Syam","30000","23"},{"Sya544m","50000","93"},{"Syam6461","70000","27"}};
		return empData;
	}
}



