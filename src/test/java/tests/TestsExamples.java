package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //чтобы не писать RestAssured.get, имопртируем статичный класс
import io.restassured.response.Response;

public class TestsExamples {

	@Test
	public void test1() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_sm_par() {
		baseURI = "http://sm10.gk.x5.ru";
		given().get("/api/v1/parameters?page=0&size=10").then().statusCode(200);
	}

	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api/";
		given().get("users?page=2").then().statusCode(200);
	}
	
	

}