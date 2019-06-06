package catalog.cucumber;
import org.junit.runner.RunWith;
import catalog.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/"
        ,glue={"catalog.cucumber.steps"}
        ,monochrome=true
           )

public class CatalogRunner extends TestBase {
      
	
}
