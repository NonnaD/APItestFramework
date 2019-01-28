import RequestPayLoads.CreateUserPayLoad;
import RequestPayLoads.UpdateUserPayload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class UpdateUser {
    public static Integer statusCode;
   @BeforeTest
    public void init() throws IOException {
       Base.init();
   }

   @Test
    public void updateUser(){
       Response post_resp = given()
               .body(CreateUserPayLoad.anyUser())
       .when()
               .post("/api/users")
       .then()
               .assertThat().statusCode(201)
               .extract().response();

       JsonPath jp = JSONPath.json(post_resp);
       System.out.println( jp.get("id"));


     Response put_resp = given()
               .param("id", jp.get("id"))
      .when()
               .put("/api/users")
      .then()
              .extract().response();
       JsonPath jput = JSONPath.json(put_resp);


      Response get_resp = given()
              .param("id", jp.get("id"))
              .body(UpdateUserPayload.update())
      .when()
              .get("/api/users/")
      .then()
              .extract().response();
     JsonPath get_jp = JSONPath.json(get_resp);
       System.out.println(get_resp.statusCode());
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
