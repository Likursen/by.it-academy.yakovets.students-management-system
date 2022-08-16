package net.javaguides.sms.api;

import net.javaguides.sms.utils.Utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class EditStudentTest {
    @Test
    public void editStudentTest() {
        baseURI = "http://localhost:8080";

        given()
                .queryParam("firstName", Utils.generateRandomSting())
                .queryParam("lastName", Utils.generateRandomSting())
                .queryParam("email", Utils.generateRandomSting())
                .patch("/students/1")
                .then()
                .statusCode(302);
    }
}