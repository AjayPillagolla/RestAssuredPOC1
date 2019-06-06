package com.jiraapp.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jiraapp.cucumber.serenity.JiraSerenitySteps;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.WithTag;
import org.json.simple.JSONObject;

//import com.jiraapp.model.JiraClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.lang.GroovyObject;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.json.Json;

public class JiraSteps {

	@Steps
	JiraSerenitySteps steps;
	static String sessionId;
	@When("^url is provided then the user should be authenticated.$")
	public void authenticateUser() {

		Response res=steps.authenticateUser().extract().response();
		String responseBody=res.asString();
		System.out.println(responseBody);
		JsonPath js=new JsonPath(responseBody);
		 sessionId=js.get("session.value");
	}

	@When("^user provides the required details and sessionId(.*) ,an issue must be created.$")
	   public void createIssue(String sessionId) {
           steps.createIssue(sessionId);
	   } 
}
	   
	 
