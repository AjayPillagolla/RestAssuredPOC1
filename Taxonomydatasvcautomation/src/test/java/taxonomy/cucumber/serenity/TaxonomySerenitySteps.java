package taxonomy.cucumber.serenity;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import taxonomy.utils.ReusableSpecificatons;

public class TaxonomySerenitySteps {
@Step("Gets all the attributes for the categoryId ")
    public ValidatableResponse getCategoryDetails(int catID){
    ValidatableResponse Response=SerenityRest.rest().given().log().all().when().get("categories/category?categoryID="+catID)
            .then();
    return Response;
}

    @Step("getting the response Json Schema validated")
    public  ValidatableResponse jsonSchemaValidation(String schemaPath ) {
        ValidatableResponse jsonschemaValidation = SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
        return jsonschemaValidation;
    }

    @Step("getting the statusCode validated")
    public  ValidatableResponse statusCode(int statusCode ) {
        ValidatableResponse statuscodeValidation = SerenityRest.then().assertThat().statusCode(statusCode);
        return statuscodeValidation;
    }

    @Step("getting the statusline validated")
    public ValidatableResponse statusline(String statusline ) {
        ValidatableResponse statusValidation = SerenityRest.then().assertThat().statusLine(statusline);
        return statusValidation;
    }

    @Step("getting the response Response Headers validated")
    public  ValidatableResponse responseHeaderValidation() {
        ValidatableResponse headerValidation = SerenityRest.then().assertThat().spec(ReusableSpecificatons.getGenericResponsespec());
        return headerValidation;
    }
}
