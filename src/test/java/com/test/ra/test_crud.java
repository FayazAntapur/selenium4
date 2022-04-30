package com.test.ra;

import static io.restassured.RestAssured.*;
import io.qameta.allure.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class test_crud {

    @Feature("Get Test")
    @Owner("Fayaz Antapur")
    @Description("Verify get request for profile")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void test_get(){
        baseURI = "http://localhost:3000/";
        basePath = "profile";
        given().when().get().then().statusCode(200);

    }

    @Feature("Get Test")
    @Owner("Fayaz Antapur")
    @Description("Verify get request for student")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void test_get_student(){
        baseURI = "http://localhost:3000/";
        basePath = "students";
        given().when().get().then().statusCode(200).log().all();

    }

    @Feature("Get Test")
    @Owner("Fayaz Antapur")
    @Description("Verify equal to")
    @Severity(SeverityLevel.BLOCKER)
    @Test()
    public void test_get_student_1(){
        baseURI = "https://reqres.in/";
        basePath = "api/users?page=2";
        given().when().get().then().statusCode(200).log().all().body("data[0].id", equalTo(1)).
                body("data[0].id",is(not(equalTo(34))));

    }

    @Feature("Get Test")
    @Owner("Fayaz Antapur")
    @Description("Verify has size")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void test_get_student_2(){
        baseURI = "https://reqres.in/";
        basePath = "api/users?page=2";
        given().when().get().then().statusCode(200).log().all().body("data.id", hasSize(6));


    }

    @Feature("Get Test")
    @Owner("Fayaz Antapur")
    @Description("Verify query param")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void test_query_param(){

        Response response = given().baseUri("https://reqres.in/").basePath("api/users").queryParam("page","2").when().get().andReturn();
        assert response.statusCode() == 200;
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("data[0].id");
        System.out.println(id);
    }
}
