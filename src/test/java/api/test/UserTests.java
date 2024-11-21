package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;


public class UserTests {
	
	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response response = Userendpoints.createUser(userPayload);
		response.then().log().all();
		
		response.getStatusCode();
		
	}
	

	@Test(priority=2)
	public void testGetUserByname()
	{
		Response response = Userendpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		response.getStatusCode();
		
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	
	{
		
		//update data using payload
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = Userendpoints.UpdateUser(userPayload,this.userPayload.getUsername());
		response.then().log().body();
		
		//response.statusCode();
		//checking data after update
		Response responseAfterupdate = Userendpoints.readUser(this.userPayload.getUsername());
		responseAfterupdate.getStatusCode();
		
		
		
		
	}
	
	@Test(priority=4)
	public void testdeleteUserByname()
	{
		Response response = Userendpoints.deleteUser(this.userPayload.getUsername());
		
		
		response.getStatusCode();
		
	}
	
}
