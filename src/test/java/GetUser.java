import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetUser {
    public static Integer statusCode;
    @BeforeTest
    public void init() throws IOException {
        Base.init();
    }

    @Test
    public void get_user(){
        Response get_resp = given()
                .param("id", "2")
        .when()
                .get("/api/users/")
        .then()
                .extract().response();
        JsonPath get_jp = JSONPath.json(get_resp);
        statusCode = get_resp.statusCode();
        Assert.assertTrue(get_resp.statusCode()==200);

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
