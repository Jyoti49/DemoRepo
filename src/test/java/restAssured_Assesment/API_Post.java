package restAssured_Assesment;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class API_Post 
{
	
		@Test(priority =1)
	    public void getRequest()
		{
	            given()
	            .log().all()
	            .when()
	                .get("https://dummy.restapiexample.com/api/v1/employees")
	            .then()
	              .statusCode(200);
	              
	    }
	
		
		@Test(priority =2,dependsOnMethods= {"getRequest"})
	    public void deleteRequest() 
	    {
	    
		       HashMap data =  new HashMap();
		       data.put("name","Jyoti");
		       data.put("salary", "1000000");
		       data.put("age","29");
		       
		       
		       
		       given()
		       .contentType("application/json")
		           // .body(data)
		            //.body("{\"name\": \"John Doe\", \"age\": 30}")
		        .when()
		        //.post("https://dummy.restapiexample.com/create")
		        .delete("https://dummy.restapiexample.com/api/v1/delete/6")
		        .then()
		        .statusCode(200)
		        .log().all();
		            
	    }
	
}
