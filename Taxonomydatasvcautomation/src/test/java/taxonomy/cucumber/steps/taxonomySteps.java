package taxonomy.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import taxonomy.cucumber.serenity.TaxonomySerenitySteps;
import taxonomy.testbase.TestBase;

public class taxonomySteps extends TestBase {

    @Steps
    TaxonomySerenitySteps steps;
@When("^the user sends a request with categoryID (.*)$")
    public void when_user_sends_request(int catID){
    steps.getCategoryDetails(catID);

}

    @Then("^the user verify that the status code is (\\d+)$")
    public void the_user_verify_that_the_status_code_is(int statusCode) {
        steps.statusCode(statusCode);

    }

    @And("^the status line is \"([^\"]*)\"$")
    public void the_status_line_is(String statusLine) {
       steps.statusline(statusLine);
     }

    @And("^the user validates the response header$")
    public void the_user_validates_the_response_header() {
        steps.responseHeaderValidation();
    }

    @And("^The user validates the Json Schema with schema at \"([^\"]*)\"$")
    public void the_user_validates_the_Json_Schema_with_schema_at(String schemaPath) {
        steps.jsonSchemaValidation(schemaPath);
    }

    @And("^verify that response has attributes array$")
    public void verify_that_response_has_attributes_array() {
        steps.validateAttributesHasArray();
    }

    @Then("^the response has parents array$")
    public void the_response_has_parents_array() {
        steps.validateParentsHasArray();

    }
}
