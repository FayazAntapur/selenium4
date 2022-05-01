package com.test.ra;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class test_hamcrest {

    @BeforeMethod
    public void beforetest(){
        baseURI = "http://localhost:3000/";

    }

    @Test
    public void test1(){
        basePath = "posts/48";
        given().when().get().then().statusCode(200)
                .body("title", equalTo("KGF2"))
                .and().body("title", is("KGF2"))
                .and().body("title", equalToIgnoringCase("kgf2"))
                .and().body("title", equalToCompressingWhiteSpace("KGF2"))
                .and().body("title", is(notNullValue()));

    }

    @Test
    public void test2(){
        basePath = "posts";
        given().when().get().then().statusCode(200).body("[11].id", is(99))
                .and().body("id", hasSize(12)).and().body("author", hasItem("antapur"))
                .and().body("[11].author", startsWith("Sin"))
                .and().body("[10].author", endsWith("pur"))
                .and().body("[9].title",containsString("2"))
                .and().body("[9].title", containsStringIgnoringCase("kg"));
    }

    @Test
    public void test3(){
        basePath = "posts";

        given().when().get().then().assertThat().statusCode(200)
                .and().body("[8].title", notNullValue())
                .and().body("[10]", hasKey("id"))
                .and().body("[10]", hasValue("antapur"))
                .and().body("[10]", hasEntry("title","fayazs"))
                .and().body("title", hasItem("KGF2"))
                .and().body("title", hasItems("KGF2", "fayaz"));

    }

    @Test(enabled = false)
    public void test4(){
        basePath = "posts";

        given().when().get().then().assertThat().statusCode(200)
                .and().body("", greaterThan(23))
                .and().body("", greaterThanOrEqualTo(32))
                .and().body("", lessThan(34))
                .and().body("", lessThanOrEqualTo(45))
                .and().body("", hasLength(23));
    }

    @Test
    public void test5(){

        String title, author;
        int id;
        basePath = "posts";
        Response response = given().when().get().andReturn();
        id = JsonPath.from(response.getBody().asString()).get("[11].id");
        title = JsonPath.from(response.getBody().asString()).get("[11].title");
        author = JsonPath.from(response.getBody().asString()).get("[11].author");
        System.out.println(id+" "+title+" "+ author);

        assertThat ((new Object[]{id,title,author}), is(new Object[]{99,"DDLG","Singh"}));
        //assertThat ((new Object[]{id,title,author}), is(new Object[]{991,"DDLG","Singh1"}));

    }

    @Test
    public void test6(){
        List<Integer> id;
        List<String> title;
        List<String> author;

        basePath = "posts";
        Response response = given().when().get().andReturn();

        id = new ArrayList<>();
        id = JsonPath.from(response.getBody().asString()).get("");

        title =  new ArrayList<>();
        title = JsonPath.from(response.getBody().toString()).get("");

        author = new ArrayList<>();
        author = JsonPath.from(response.getBody().asString()).get("");

        assertThat((new Object[]{id.get(0),title.get(0),author.get(0)}),is(new Object[]{"","",""}));
    }

    @Test
    public void test7(){

    }
}
