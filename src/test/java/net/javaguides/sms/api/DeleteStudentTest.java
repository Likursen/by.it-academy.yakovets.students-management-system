package net.javaguides.sms.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudentTest {

    @Test
    public void deleteStudent() {
        RestAssured.baseURI = "http://localhost:8080";

        given()
                .when()
                .delete("/students/1")
                .then()
                .statusCode(200);
    }
}