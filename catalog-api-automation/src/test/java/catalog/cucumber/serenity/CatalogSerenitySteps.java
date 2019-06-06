package catalog.cucumber.serenity;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import catalog.utils.ReusableSpecificatons;

public class CatalogSerenitySteps {

    Logger log = LoggerFactory.getLogger(CatalogSerenitySteps.class);

    @Step("getting the response for OmniItem Id")
    public ValidatableResponse getItemID(int ItemID, String Assoctype) {

        log.info("APPLICATION_HOST : {}", RestAssured.baseURI);

        ValidatableResponse response = SerenityRest.rest().given()
                .when()
                .get("/personalization/items/" + ItemID + "?associationType=" + Assoctype)
                .then()
                .log()
                .all();

        log.info("Response : " + response.extract().asString());

        return response;

    }
}