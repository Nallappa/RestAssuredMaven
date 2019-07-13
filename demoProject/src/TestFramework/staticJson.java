package TestFramework;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.resources;
import files.payLoad;;

public class staticJson {

	public static void main(String[] args) throws IOException {
//	@Test
//	public static void addBook() {
//		
//		Properties prop=new Properties();
//		FileInputStream fis=new FileInputStream("C:\\Users\\nalpasav\\Documents\\Exit\\RestAssured\\project\\demoProject\\src\\files\\env.properties");
//		prop.load(fis);
	

		//Task 1- Grab the response
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
//		header("Content-Type","application/json").
		body(GenerateStringFromResource("C:\\Users\\nalpasav\\Documents\\Exit\\RestAssured\\project\\demoProject\\src\\files\\static.json")).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	
		// Task 2- Grab the Place ID from response
		extract().response();
		
		String responseString=res.asString();
		System.out.println(responseString);
		JsonPath js= new JsonPath(responseString);
		String placeid=js.get("ID");
		System.out.println(placeid);
		
	}
	

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	




	
	}

