package com.test.ra;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pojo.pages;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class crud_post {


    @Feature("Get Posts Test")
    @Step("verify posts get request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify get for posts")
    @Test(description = "testng description")
    public void test1(){
        baseURI="http://localhost:3000/";
        basePath = "posts";
        given().when().get().then().assertThat().statusCode(200);
    }

    @Feature("Get Posts Test")
    @Step("verify get json path request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify get json path for posts")
    @Test(description = "verify get json path")
    public void test2(){
        baseURI="http://localhost:3000/";
        basePath = "posts";
        given().when().get().then().assertThat().statusCode(200).log().all().body("[0].id", equalTo(1));
    }

    @Feature("Get Posts Test")
    @Step("verify not null request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify get not null for posts")
    @Test(description = "verify get not null path")
    public void test3(){
        baseURI="http://localhost:3000/";
        basePath = "posts";
        given().when().get().then().assertThat().statusCode(200).log().all().body("[0].title", is(not(nullValue())));
    }

    @Feature("Get Posts Test")
    @Step("verify failed request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify failed for posts")
    @Test(description = "verify failed path")
    public void test4(){
        baseURI="http://localhost:3000/";
        basePath = "posts";
        given().when().get().then().assertThat().statusCode(400).log().all().body("titles", is(not(nullValue())));
    }

    @Feature("Get Posts Test")
    @Step("verify skip request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify skip for posts")
    @Test(description = "verify sip path")
    public void test5(){
        throw new SkipException("skipping test");
    }

    @Feature("Get Posts Test")
    @Step("verify string post request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify string post for posts")
    @Test(description = "verify string post", enabled = false)
    public void test6(){
        baseURI="http://localhost:3000/";
        basePath="posts";
        String s = "    {\n" +
                "        \"id\": 3,\n" +
                "        \"title\": \"servers\",\n" +
                "        \"author\": \"codes\"\n" +
                "    }";
        given().body(s).when().post().then().statusCode(201);
    }

    @Feature("Get Posts Test")
    @Step("verify hashmap post request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify hashmap post for posts")
    @Test(description = "verify hashmap post",enabled = false)
    public void test7(){
        baseURI="http://localhost:3000/";
        basePath="posts";
        HashMap<String ,Object> hm = new HashMap<>();
        hm.put("id",48);
        hm.put("title", "fayaz");
        hm.put("author", "antapur");
        JSONObject jsonObject = new JSONObject(hm);
        given().header("Content-Type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString()).when().post().then().statusCode(201);
    }

    @Feature("Get Posts Test")
    @Step("verify hashmap post request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.BLOCKER)
    @Description("verify hashmap post for posts")
    @Test(description = "verify hashmap post", enabled = false)
    public void test8(){
        baseURI="http://localhost:3000/";
        basePath="posts";
        JSONObject hm = new JSONObject();
        hm.put("id",75);
        hm.put("title", "fayazs");
        hm.put("author", "antapur");
        System.out.println(hm.toJSONString());

        given().header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(hm.toJSONString()).when().post().then().statusCode(201);
    }
    @Feature("Get Posts Test")
    @Step("verify hashmap put request")
    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.NORMAL)
    @Description("verify hashmap put for posts")
    @Test(enabled = false)
    public void test9(){
        baseURI="http://localhost:3000/";
        basePath="posts/42";

        JSONObject js = new JSONObject();
        js.put("author", "james");

        given().header("Content-Type","application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(js.toJSONString())
                .when().put()
                .then().assertThat().statusCode(200);


    }

    @Owner("Fayaz Antapur")
    @Feature("Get posts Test")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("verify patch request")
    @Test(enabled = false)
    public void test10(){
        baseURI="http://localhost:3000/";
        basePath="posts/48";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title", "KGF2");

        given().header("Content-Type", "application/json").contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(jsonObject.toJSONString()).when().patch().then()
                .assertThat().statusCode(200);
    }

    @Owner("Fayaz Antapur")
    @Feature("Get delete Test")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("verify delete request")
    @Test(enabled = false, description = "test delete")
    public void test11(){
        baseURI="http://localhost:3000/";
        basePath="posts/47";

        given().when().delete().then()
                .assertThat().statusCode(200);
    }

    @Owner("Fayaz Antapur")
    @Severity(SeverityLevel.MINOR)
    @Description("verfiy pojo class")
    @Feature("Get posts Test")
    @Test(enabled = false)
    public void test12() throws IOException {
        baseURI="http://localhost:3000/";
        basePath="posts";

        ObjectMapper objectMapper = new ObjectMapper();
        pages page = objectMapper.readValue(new File("E:\\com.selenium4.changes\\src\\main\\resources\\post.json"), pages.class);
        page.setId(99);
        page.setTitle("DDLG");
        page.setAuthor("Singh");

        given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(page).when().post().then().statusCode(201);
    }






}
