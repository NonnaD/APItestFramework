import io.restassured.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static void init() throws IOException {
        FileInputStream fis = new FileInputStream(new File("./src/main/java/resources/data.properties"));
        Properties prop = new Properties();
        prop.load(fis);
        RestAssured.baseURI="https://reqres.in/";
    }
}
