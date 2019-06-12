package taxonomy.cucumber.serenity;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import taxonomy.utils.ReusableSpecificatons;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;

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

    @Step("Verify that response has attribute array")
    public ValidatableResponse validateAttributesHasArray() {

        ExtractableResponse<Response> response = SerenityRest.then().extract();
        List<Integer> attributesList = response.path("Attributes");
        System.out.println(attributesList.toString());
        ValidatableResponse attributesarrayValidation = SerenityRest.then().assertThat().body("Attributes", hasItems(attributesList.toArray()));
        List<Integer> parentsList = response.path("Parents");
        System.out.println(parentsList.toString());
        ValidatableResponse parentsListValidation = SerenityRest.then().assertThat().body("Parents", hasItems(parentsList.toArray()));

        return attributesarrayValidation;


    }

    @Step("Verify that response has attribute array")
    public ValidatableResponse validateParentsHasArray() {

        ExtractableResponse<Response> response = SerenityRest.then().extract();
        List<Integer> parentsList = response.path("Parents");
        System.out.println(parentsList.toString());
        ValidatableResponse parentsListValidation = SerenityRest.then().assertThat().body("Parents", hasItems(parentsList.toArray()));

        return parentsListValidation;


    }
}
