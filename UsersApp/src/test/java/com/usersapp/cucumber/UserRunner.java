package com.usersapp.cucumber;

import org.junit.runner.RunWith;

import com.usersapp.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/")

public class UserRunner extends TestBase {
      
	
}
