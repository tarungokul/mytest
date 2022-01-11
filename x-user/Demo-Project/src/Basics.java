import io.restassured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//Add a new code
//Test1
//test2
//test3
//test4
//test5
//test6

public class Basics {
	public static void main(String args[])
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String Response = given().relaxedHTTPSValidation().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/add/json")
		        .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		        .header("server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();
		        
		System.out.println(Response);
		JsonPath js=new JsonPath(Response);
		System.out.println(js.getString("place_id"));
		
		
				
	
	}	

}
