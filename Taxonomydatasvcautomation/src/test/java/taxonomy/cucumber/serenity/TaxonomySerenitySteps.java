package taxonomy.cucumber.serenity;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TaxonomySerenitySteps {
@Step("Gets all the attributes for the categoryId ")
    public ValidatableResponse getCategoryDetails(int catID){
    ValidatableResponse Response=SerenityRest.rest().given().log().all().when().get("categories/category?categoryID="+catID)
            .then().log().all();
    return Response;
}

    @Step("getting the response Json Schema validated")
    public  ValidatableResponse jsonSchemaValidation(String schemaPath ) {
        ValidatableResponse jsonschemaValidation = SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
        return jsonschemaValidation;
    }
}
