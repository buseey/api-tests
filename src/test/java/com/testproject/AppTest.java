package com.testproject;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetPost() {
        given()
            .when()
                .get("/posts/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue())
                .time(lessThan(3000L));
    }
}