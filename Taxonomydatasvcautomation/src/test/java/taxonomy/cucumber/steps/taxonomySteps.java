package taxonomy.cucumber.steps;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
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

    @When("^The user validates the Json Schema with schema at \"([^\"]*)\"$")
    public void the_user_validates_the_Json_Schema_with_schema_at(String schemaPath) {
        steps.jsonSchemaValidation(schemaPath);
    }
}
