package com.jiraapp.cucumber.serenity;

import com.usersapp.model.UsersClass;

import io.restassured.http.ContentType;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {

   
	@Step("This will create a new user with name of {0}, {1}")
	public ValidatableResponse createUser(String name, String job) {
	   UsersClass user=new UsersClass();
	   user.setName(name);
	   user.setJob(job);
	   
	   return  SerenityRest.rest()
			   .given()
			   .contentType(ContentType.JSON)
			   .when()
			   .body(user)
			   .post()
			   .then();			   		   
   }
    
   @Step("Get infomation for user with userId : {0}")
   public ValidatableResponse getSingleUser(String userId) {
	 return  SerenityRest.rest()
	   .given()
	   .when()
	   .get("/" +userId)
	   .then();
   }
  
   @Step("Updating Student Information for Id : {0}")
    public ValidatableResponse updateUser( int userId,String name, String job) {
    	
       UsersClass user=new UsersClass();
  	   user.setName(name);
  	   user.setJob(job);
  	   
  	   return SerenityRest.rest()
  			   .given()
  			   .contentType(ContentType.JSON)
  			   .when()
  			   .body(user)
  			   .put("/" +userId )
  			   .then();	
    }
    
    @Step("deleting student information with ID :{0}")
    public void deleteUser(String userId) {
    	SerenityRest.rest()
   			   .given().when()
   			   .delete("/" +userId );
   					   }
}
