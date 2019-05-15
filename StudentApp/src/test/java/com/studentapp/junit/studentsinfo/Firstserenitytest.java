package com.studentapp.junit.studentsinfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
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
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException {
	 
     File file = new File("E:/file.txt");
     FileReader fr=new FileReader(file);
	}
	
	@Manual
	@Test
	public void thisisaManualTest() {
	 
	}
	
	@Title("This test will get all the information of the students from the studentapp")
	@Test
	public void Test01() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
}
