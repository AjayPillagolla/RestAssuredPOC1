package catalog.cucumber.steps;

import catalog.cucumber.serenity.JiraSerenitySteps;

//import JiraClass;

import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

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
	   
	 
