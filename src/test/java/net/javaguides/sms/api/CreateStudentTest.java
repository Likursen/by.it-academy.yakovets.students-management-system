package net.javaguides.sms.api;

import net.javaguides.sms.utils.Utils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreateStudentTest {

    @Test
    public void createStudentTest() {
        baseURI = "http://localhost:8080";

        given()
                .queryParam("firstName", Utils.generateRandomSting())
                .queryParam("lastName", Utils.generateRandomSting())
                .queryParam("email", Utils.generateRandomSting())
                .post("/students")
                .then()
                .statusCode(302);
    }
}