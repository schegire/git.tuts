package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import api.payload.User;

import io.restassured.response.Response;


//userendpoints.java
//created to perform create,read,update,delete request to the user API.

public class Userendpoints {
	
	/* we need to have payload that we need to implement 
	particular method taking some payload -payload is nothing but request body because whenever we send request we need body right
	that body we take as a payoad*/
	
	public static Response createUser(User payload)
	
	{
		Response response = given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload) //whatever the input(nothing but payload) we have captured that we need to pass in body
		.when()
		.post(Routes.post_url);  // if we put semicolon it will return some response so in given put variable .
		
		return response;
	}
	
public static Response readUser(String userName)
	
	{
		 Response response= given()
		        .pathParam("username",userName)
		.when()
		    .get(Routes.get_url);
		
		return response;
	}

public static Response UpdateUser(User payload,String userName)

{
	Response response = given()
	.contentType("application/json")
	.accept("application/json")
	.pathParam("username",userName)
	.body(payload)
	
	.when()
	.put(Routes.update_url);  
	
	return response;
}
public static Response deleteUser(String userName)

{
	 Response response= given()
	        .pathParam("username",userName)
	.when()
	    .delete(Routes.delete_url);
	
	return response;
}

}
