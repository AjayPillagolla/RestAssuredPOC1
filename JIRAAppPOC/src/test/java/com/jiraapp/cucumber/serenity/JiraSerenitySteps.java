package com.jiraapp.cucumber.serenity;

import com.jiraapp.model.JiraClass;

import io.restassured.http.ContentType;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class JiraSerenitySteps {

    @Step("This will generate a cookie for authentication")
	public ValidatableResponse authenticateUser(){
		return SerenityRest.rest().given().log().all().contentType(ContentType.JSON)
				.body("{ \n" +
						"\"username\": \"admin\",\n" +
						"\"password\": \"admin123\" \n" +
						"}")
				.post("rest/auth/1/session").then();
	}

	@Step("This will create a new issue in JIRA")
	public ValidatableResponse createIssue(String sessionId) {

		 return SerenityRest.rest().given()
				 .header("Cookie","JSESSIONID="+sessionId)
				 .log().all()
				.contentType(ContentType.JSON)
				.when().body("{\r\n" +
				" \"fields\": {\r\n" +
				"        \"summary\": \"Defect6\",\r\n" +
				"        \"description\":\"Test Defect6\",\r\n" +
				"        \"issuetype\": {\r\n" +
				"            \"name\": \"Bug\"\r\n" +
				"        },\r\n" +
				"         \"project\": {\r\n" +
				"            \"key\": \"RES\"\r\n" +
				"        }\r\n" +
				" }\r\n" +
				" }").post("rest/api/2/issue").then().log().all();
   }
}
