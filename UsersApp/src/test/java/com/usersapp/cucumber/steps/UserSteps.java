package com.usersapp.cucumber.steps;

import com.usersapp.cucumber.serenity.UserSerenitySteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.lang.GroovyObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class UserSteps {

	   @Steps
	   UserSerenitySteps steps;
	   static String userId;
	
	   @When("^user sends a GET request to the list endpoint ,They must get back a valid status code 200$")
	   public void verify_statuscode200() {
		   SerenityRest.rest()
		   .given()
		   .when()
		   .get()
		   .then()
		   .statusCode(200);
	   }
	   
	   @When("^I create a new user providing the information name(.*) job(.*)$")
	   public void createUser(String name,String job) {
		   Response response=steps.createUser(name, job).statusCode(201)
					.extract().response();
		   System.out.println("Response is " +response);
		   JsonPath jsonPathEvaluator=response.jsonPath();
		   userId = jsonPathEvaluator.get("id");
		  
	   }
	   
	   
	   
	   @When("^I provide the id(.*) information the name(.*) job(.*) of user will be updated$")
	   public void updateUser(String userId,String name,String job) {
		   steps.updateUser(userId,name, job);
	   }
}
