package api.endpoints;

/*
 
 Swagger URL-        https://petstore.swagger.io
 Create user(Post):  https://petstore.swagger.io/v2/user
 Get user (Get):     https://petstore.swagger.io/v2/user/{username}
 Update user(Put):   https://petstore.swagger.io/v2/user/{username}
 Delete user(Delete):https://petstore.swagger.io/v2/user/{username}
 
 
 
 
 */

public class Routes {
	
	//maitain urls in routes class
	
	public static  String   base_url="https://petstore.swagger.io";

	
	//User module
	public static  String   post_url=  base_url+"/user";
	public static  String   get_url=  base_url+"/user/{username}";
	public static  String   update_url=  base_url+"/user/{username}";
	public static  String   delete_url=  base_url+"/user/{username}";


	
	
	
	//store module
	
	//here you will create store module urls in fututre if u want
	
	//Pet module
	
		//here you will create  Pet module urls in fututre if u want
	
	
	
}
