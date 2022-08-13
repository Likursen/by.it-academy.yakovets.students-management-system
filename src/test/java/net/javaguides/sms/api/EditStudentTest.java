package net.javaguides.sms.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class EditStudentTest {
    @Test
    public void editStudentTest() {
        baseURI = "http://localhost:8080";

        given()
                .queryParam("firstName", "newFirstName")
                .queryParam("lastName", "newLastName")
                .queryParam("email", "newRandomEmail@mail.com")
                .patch("/students/1")
                .then()
                .statusCode(302);
    }
}