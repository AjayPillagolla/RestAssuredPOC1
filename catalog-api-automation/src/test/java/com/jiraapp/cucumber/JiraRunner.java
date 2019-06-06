package com.jiraapp.cucumber;
import net.thucydides.core.annotations.WithTags;
import org.junit.runner.RunWith;
import com.jiraapp.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/"
           )

public class JiraRunner extends TestBase {
      
	
}
