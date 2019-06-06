package catalog.cucumber.steps;

import catalog.cucumber.serenity.CatalogSerenitySteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class catalogSteps {

    @Steps
    CatalogSerenitySteps steps;

    @When("^the user sends a request for (\\d+) and association type as \"([^\"]*)\"$")
    public void the_user_sends_a_request_for_and_association_type_as(int ItemID, String Assoctype) {
        steps.getItemID(ItemID, Assoctype);

    }

}