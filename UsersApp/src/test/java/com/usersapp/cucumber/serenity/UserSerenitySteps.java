package com.usersapp.cucumber.serenity;

import com.usersapp.model.UsersClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {

   
	@Step("This will create a new user with name of {0}, {1}")
	public ValidatableResponseImpl createUser(String name, String job) {
	   UsersClass user=new UsersClass();
	   user.setName(name);
	   user.setJob(job);
	   
	   return (ValidatableResponseImpl) SerenityRest.rest()
			   .given()
			   .contentType(ContentType.JSON)
			   .when()
			   .body(user)
			   .post()
			   .then();			   
			   
   }
    
   @Step("Updating Student Information ")
    public ValidatableResponse updateUser( String userId,String name, String job) {
    	
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
    
    
}
