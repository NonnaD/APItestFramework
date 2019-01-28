import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSONPath {
    public static JsonPath json(Response response){
        JsonPath jp = new JsonPath(response.prettyPrint());
        return jp;

    }
}
