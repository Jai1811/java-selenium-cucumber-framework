package coeur;

import org.json.simple.*;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestassuredApi {

	public int getData(String URI) {
//		RestAssured.authentication=RestAssured.preemptive().basic(Properties.getProperties("apiUsername"), Properties.getProperties("apiPassword"));
		
		RestAssured.baseURI = URI;
		RequestSpecification httpRequest = RestAssured.given(); 
		Response resp=httpRequest.request(Method.GET,"/Hyderabad");
		
		String statusCode = resp.statusLine();
		System.out.println("This is the status code = "+statusCode);
		
		System.out.println("This is the response ");
		System.out.println(resp.getBody().asString());
		
		//request payload sending along with post request
		JSONObject requestParams  = new JSONObject();
		requestParams.put("FirstName", "TestXcsdvcdcdccdsdZ123hght");
		requestParams.put("LastName", "TestXYZ123");
		requestParams.put("UserName", "TestXYZ123dvdf");
		requestParams.put("Password", "TestXYZ123xyz");
		requestParams.put("Email", "JohnXyzcdjvdcd@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		Response respPost= httpRequest.request(Method.POST,"/register");
		
		System.out.println(respPost.getBody().asString());
		
		String successCode = respPost.jsonPath().get("SuccessCode");
		
		System.out.println("This is the successcode = "+successCode);
		int code = respPost.statusCode();
		
		return code;
		
		
		
	}
//	public String getData(String data) {
//		
//		
//		
//		
//		return null;
//		
//		
//		
//		
//	}
	
	
}
