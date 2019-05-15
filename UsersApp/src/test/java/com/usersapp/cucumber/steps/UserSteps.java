package com.usersapp.cucumber.steps;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class UserSteps {

	   @When("^user sends a GET request to the list endpoint ,They must get back a valid status code 200$")
	   public void verify_statuscode200() {
		   SerenityRest.rest()
		   .given()
		   .when()
		   .get()
		   .then()
		   .statusCode(200);
	   }
}
