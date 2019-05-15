package com.usersapp.junit.usersinfo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.model.UsersClass;
import com.usersapp.testbase.TestBase;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class UsersCRUDTest extends TestBase{

	static String name="SMOKEUSER";
	static String job="SMOKEUSER";
	
	
	@Title("This test will create a new user")
	@Test
	public void createUser() {
	
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
	
	
	
	@Title("This test will update an existng user")
	@Test
	public void updateUser() {
	
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
