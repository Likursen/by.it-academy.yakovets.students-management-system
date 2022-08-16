package net.javaguides.sms.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetStudentsTest {

    @Test
    public void getStudentsTest() {
        RestAssured.baseURI = "http://localhost:8080";

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/students")
                .then()
                .statusCode(200);
    }
}