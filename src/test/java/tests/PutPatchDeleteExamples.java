package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.*;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		request.put("name","Raghav");
		request.put("job", "Teacher");
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void testPatch() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		request.put("name","Raghav");
		request.put("job", "Teacher");
		
		baseURI = "https://reqres.in";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in";
		when().
			delete("/api/users/2").
		then().
			statusCode(204)
			.log().all();
	}

}
