package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.StudentClass;
import com.studentapp.model.UsersClass;
import com.studentapp.testbase.TestBase;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class PostTest extends TestBase{

	static String name="SMOKEUSER";
	static String job="SMOKEUSER";
	
	
	@Title("This test will create a new student")
	@Test
	public void createStudent() {
	
		UsersClass user=new UsersClass();
		user.setName(name);
		user.setJob(job);
		
		SerenityRest
		 .given()
		 .contentType(ContentType.JSON)
		 .log()
		 .all()
		 .when()
		 .body(user)
		 .post()
		 .then()
		 .log()
		 .all().statusCode(201);
	}
}
