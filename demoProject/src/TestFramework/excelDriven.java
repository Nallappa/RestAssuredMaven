package TestFramework;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.resources;
import files.payLoad;;

public class excelDriven {
	
	
	public static void main(String[] args) throws IOException {
//		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\nalpasav\\Documents\\Exit\\RestAssured\\project\\demoProject\\src\\files\\env.properties");
		prop.load(fis);
	

		//Task 1- Grab the response
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		
		queryParam("key",prop.getProperty("key")).
		body(payLoad.getPostData()).
		when().
		post(resources.placePostData()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		
		// Task 2- Grab the Place ID from response
		extract().response();
		String responseString=res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String placeid=js.get("place_id");
		System.out.println(placeid);
		
	
		
	}
}
