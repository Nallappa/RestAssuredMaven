package files;

public class payLoad {

	public static String getPostData() {
		
		String payload = "{"+
				  "\"location\": {"+
				    "\"lat\": -33.8669710,"+
				    "\"lng\": 151.1958750"+
				  "},"+
				  "\"accuracy\": 50,"+
				  "\"name\": \"Google Shoes!\","+
				  "\"phone_number\": \"(02) 9374 4000\","+
				  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
				  "\"types\": [\"shoe_store\"],"+
				  "\"website\": \"http://www.google.com.au/\","+
				  "\"language\": \"en-AU\""+
				"}";
		return payload;
	}
	
	public static String addBook(String as,String is) {
		
		String payLoadAdd ="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with script1\",\r\n" + 
				"\"isbn\":\""+is+"\",\r\n" + 
				"\"aisle\":\""+as+"\",\r\n" + 
				"\"author\":\"Nalli1\"\r\n" + 
				"}";
		
		return payLoadAdd;
	}
}
