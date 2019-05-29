package com.jiraapp.cucumber.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jiraapp.model.JiraClass;

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

public class JiraSteps {
	    
	   
	   @When("^user provides the required details,an  issue must be created.$")
	   public void createIssue() {         
		  
		   Map<String,String> issuetype=new HashMap<String, String>();
			  issuetype.put("name", "Bug");  
		  
		   Map<String,String> project=new HashMap<String, String>();
		   project.put("Key", "RES");
			  
		  Map<String,Object>  fields=new HashMap<String, Object>();
		  fields.put("project", project);
		  fields.put("summary", "Defect5");
		  fields.put("description", "TestDefect5");
		  fields.put("issuetype", issuetype);
		  
		  Map<String,Object>  body=new HashMap<String, Object>();
           body.put("fields", fields);
		  
		  
		  SerenityRest.rest().given().cookie("SESSIONID", "81BA965998FDBC3AB3D68AA72C6E7CD4").log().all()
		  .contentType(ContentType.JSON)
		  .when().body(body).post().then().log().all();
		  
	   } 
}
	   
	 
