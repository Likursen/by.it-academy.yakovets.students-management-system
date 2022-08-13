package net.javaguides.sms.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreateStudentTest {

    @Test
    public void createStudentTest() {
        baseURI = "http://localhost:8080";

        given()
                .queryParam("firstName", "sdvsddsv")
                .queryParam("lastName", "dsdsdf")
                .queryParam("email", "sdfdsfsdf")
                .post("/students")
                .then()
                .statusCode(302);
    }
}