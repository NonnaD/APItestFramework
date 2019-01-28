import RequestPayLoads.CreateUserPayLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CreateUser {
    //TC1. Create new User (POST) and validate that it was successfully created (GET)

    public static Integer statusCode;
    @BeforeTest
    public void init() throws IOException {
        Base.init();
    }

    @Test
    public void user(){
        Response post_resp = given()
                .body(CreateUserPayLoad.anyUser())
        .when()
                .post("/api/users")
        .then()
                .assertThat().statusCode(201)
                .extract().response();

        statusCode = post_resp.statusCode();
        JsonPath jp = JSONPath.json(post_resp);
        System.out.println( jp.get("id"));

        Response get_resp = given()
              .param("id", jp.get("id"))
        .when()
              .get("/api/users/")
        .then()
               .extract().response();
        String sc = StatusCodeDecoder.statusCode(get_resp.statusCode());
        System.out.println(sc);

        Assert.assertTrue(get_resp.statusCode() == 200);

    }


    @AfterMethod
    public void writeResult(ITestResult result){
        System.out.println(statusCode);
        if(result.getStatus() == ITestResult.FAILURE){
            String message = StatusCodeDecoder.statusCode(statusCode);
            System.out.println(message);

        }
    }
}
