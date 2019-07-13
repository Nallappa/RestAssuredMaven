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
import org.testng.annotations.Test;
import org.testng.xml.XmlPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import files.resources;
import files.payLoad;
import files.ReusableMethods;

public class xmlReading {
	
	
	private static XmlPath XmlPath;


	public static void main(String[] args) throws IOException {
//		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\nalpasav\\Documents\\Exit\\RestAssured\\project\\demoProject\\src\\files\\env.properties");
		prop.load(fis);
	
		String postxml = GenerateStringFromResource("C:\\Users\\nalpasav\\Documents\\Exit\\RestAssured\\project\\demoProject\\src\\files\\post.xml");
		//Task 1- Grab the response
		RestAssured.baseURI="http://216.10.245.166";
		Response res=given().
		
		queryParam("key",prop.getProperty("key")).
		body(postxml).
		when().
		post(resources.placePostDataxml()).
		then().assertThat().statusCode(200).and().contentType(ContentType.XML).
		extract().response();
		
		// Task 2- Grab the Place ID from response
		XmlPath x = ReusableMethods.rawToXML(res);
//		String responseString=res.asString();
//		System.out.println(responseString);
//		XmlPath x = new XmlPath(responseString);
		String str = x.get("response.place_id");
		System.out.println(str);
//		System.out.println(x.get("PlaceAddResponse.place_id"));
		
//		String placeid=js.get("place_id");
//		System.out.priXmlPathntln(placeid);
		
	
	}
	
	
	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
		

}
