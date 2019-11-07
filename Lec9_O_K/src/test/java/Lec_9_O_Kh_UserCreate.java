import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Lec_9_O_Kh_UserCreate {
    String path = "https://petstore.swagger.io/v2/user";
    String pathUser = "/Helen";
    String contType = "Content-Type";
    String json = "application/json";
    String value = "Helen";
    String key = "username";
    JSONObject requestParams;
    RequestSpecification request;
    Response postResponse;
    Response getResponse;
    Response deleteResponse;

    public void userRequestParams() throws JSONException {
        String user = "{\n" +
                "  \"id\": 11,\n" +
                "  \"username\": \"Helen\",\n" +
                "  \"firstName\": \"Elena\",\n" +
                "  \"lastName\": \"Khala\",\n" +
                "  \"email\": \"Helen@gmail.com\",\n" +
                "  \"password\": \"helen11\",\n" +
                "  \"phone\": \"0000\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        requestParams = new JSONObject(user);
    }

    @BeforeTest
    public void templateRequst() throws JSONException {
        userRequestParams();
        request = given();
        request.header(contType, json);
        request.body(requestParams.toString());
        postResponse = request.post(path);
        getResponse = request.get(path + pathUser);
        deleteResponse = request.delete(path + pathUser);
    }

    @Test
    public void postRequest() {
        int statusCode = postResponse.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getRequestCreateUser() {
        String keyValue = getResponse.path(key).toString();
        Assert.assertEquals(keyValue, value);
    }

    @Test
    public void deleteRequestCreateUser() {
        int statusCode1 = deleteResponse.getStatusCode();
        Assert.assertEquals(statusCode1, 200);
    }
}
