package PartTwo;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PartTwo_QuestionThree {

	public static void main(String[] args) {
		int statusCode;
		byte [] png = null;
		String baseURL="https://httpbin.org/image";
		
		RestAssured.baseURI= baseURL;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/png");
		
		png = response.getBody().asByteArray();
		if(png.equals(null))
		{
			System.out.println("Response ISSUE");
		}
		else
			{System.out.println("Response Body is OK");}

		statusCode = response.statusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
	}

}
