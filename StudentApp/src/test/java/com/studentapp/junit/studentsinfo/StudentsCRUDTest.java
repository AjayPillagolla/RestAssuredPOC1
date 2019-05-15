package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class StudentsCRUDTest extends TestBase{

	static String firstName="SMOKEUSER";
	static String lastName="SMOKEUSER";
	static String programme="ComputerScience";
	static String email="xyz@gmail.com";
	
	
	@Title("This test will create a new student")
	@Test
	public void createStudent() {
	
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		StudentClass student=new StudentClass();
		student.setFirstname(firstName);
		student.setLastname(lastName);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		SerenityRest
		 .given()
		 .contentType(ContentType.JSON)
		 .log()
		 .all()
		 .when()
		 .body(student)
		 .post()
		 .then()
		 .log()
		 .all().statusCode(201);
	}
}
