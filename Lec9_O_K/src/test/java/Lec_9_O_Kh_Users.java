import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Lec_9_O_Kh_Users {
    String path = "https://petstore.swagger.io/v2/user";
    String pathUsers = "/createWithList";
    String zeroPathUser = "/Helen0";
    String onePathUser = "/Helen1";
    String contType = "Content-Type";
    String json = "application/json";
    String value = "Helen";
    String key = "username";
    JSONArray RequestParams;
    RequestSpecification request;
    Response postResponse;
    Response getResponse;
    Response deleteResponse;

    public void userRequestParams() throws JSONException {
        String userOne = "{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"Helen1\",\n" +
                "  \"firstName\": \"Elena1\",\n" +
                "  \"lastName\": \"Khala1\",\n" +
                "  \"email\": \"Helen@gmail.com\",\n" +
                "  \"password\": \"helen11\",\n" +
                "  \"phone\": \"0000\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        String userZero = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"Helen0\",\n" +
                "  \"firstName\": \"Elena0\",\n" +
                "  \"lastName\": \"Khala0\",\n" +
                "  \"email\": \"Helen@gmail.com\",\n" +
                "  \"password\": \"helen11\",\n" +
                "  \"phone\": \"0000\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        String users = "[" + userOne + ", " + userZero + "]";
        RequestParams = new JSONArray(users);
    }

    @BeforeTest
    public void templateRequst() throws JSONException {
        userRequestParams();
        request = given();
        request.header(contType, json);
        request.body(RequestParams.toString());
        postResponse = request.post(path + pathUsers);
        getResponse = request.put(path + zeroPathUser);
        deleteResponse = request.delete(path + zeroPathUser);
        deleteResponse = request.delete(path + onePathUser);
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
