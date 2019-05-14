package com.studentapp.junit;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.requirements.SerenityTestCaseFinder;

@RunWith(SerenityRunner.class)
public class Firstserenitytest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Test
	public void getAllStudents() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	@Test
	public void thisisaFailingTest() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void thisisaPendingTest() {
		
	}
	
	@Ignore
	@Test
	public void thisisaSkippedTest() {
		
	}
	
	
	@Test
	public void thisisaTestWithError() {
	 
		System.out.println("this is an error" +(5/0));
	}
}
