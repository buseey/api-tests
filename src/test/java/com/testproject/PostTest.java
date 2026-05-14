package com.testproject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testCreatePost() {
        String body = """
            {
                "title": "Test Basligi",
                "body": "Test icerik",
                "userId": 1
            }
            """;

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("Test Basligi"))
            .body("id", notNullValue())
            .time(lessThan(3000L));
    }
}