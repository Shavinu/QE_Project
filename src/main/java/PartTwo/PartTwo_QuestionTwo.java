package PartTwo;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PartTwo_QuestionTwo {

	public static void main(String[] args) {
		try
		{
			String url,baseURL="https://httpbin.org/delay";
			int delayTime = 3;
			RestAssured.baseURI= baseURL;
			
			RequestSpecification httpRequest = RestAssured.given();
			
			Response response = httpRequest.request(Method.POST,Integer.toString(delayTime));
			
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is_: "+"\n"+responseBody);
			
			int statusCode = response.getStatusCode();
			System.out.println("status code is: "+statusCode);
			Assert.assertEquals(statusCode, 200);
			
			String statusLine = response.getStatusLine();
			System.out.println(statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			
			url = response.jsonPath().get("url");
			Assert.assertEquals(url, baseURL+"/"+delayTime);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}
