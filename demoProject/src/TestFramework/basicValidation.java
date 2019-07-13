package TestFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import files.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import files.ReusableMethods;

public class basicValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		Response res = given().
		        param("query","restaurants+in+Sydney").
		        param("key","AIzaSyBvQaVSi9BjNyfvrU9d6Biw4XdJrVtyXkg").
		        when().
		        get("/maps/api/place/textsearch/json").
		        then().assertThat().
		        statusCode(200).and().contentType(ContentType.JSON).log().headers().
//		        body("results[0].name",equalTo("Aria Restaurant Sydney")).
		        extract().response();
		
			    JsonPath x = ReusableMethods.rawToJson(res);
			    int count=x.get("results.size()");
			    for(int i=0;i<count;i++)
			   {
				 String s =  x.get("results["+i+"].name");
//				 System.out.println(s);
			   }

	
	///Validations
		
		               
	}

}


//String responseString=res.asString();
////System.out.println(responseString);
//JsonPath js= new JsonPath(responseString);
//System.out.println(js);
////String placeid=js.get("place_id");
////System.out.println(placeid);
////