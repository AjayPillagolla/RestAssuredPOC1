package com.jiraapp.cucumber.serenity;

import com.jiraapp.model.JiraClass;

import io.restassured.http.ContentType;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class JiraSerenitySteps {

   
	@Step("This will create a new user with name of {0}, {1}")
	public ValidatableResponse createIssue(String name, String job) {
	   JiraClass user=new JiraClass();
	   user.setName(name);
	   
	   return  SerenityRest.rest()
			   .given()
			   .contentType(ContentType.JSON)
			   .when()
			   .body(user)
			   .post()
			   .then();			   		   
   }
}
