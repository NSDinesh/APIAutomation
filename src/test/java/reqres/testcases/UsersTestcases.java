package reqres.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.api.ReqResApi;
import reqres.payload.CreateUsersPayload;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class UsersTestcases {

    @Test
    public void createNewUsers(){
        //direct call
        Response response = RestAssured.given()
                .baseUri("https://reqres.in/api/users")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .log().all().
                post()
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(),201);

        //using method from RestUtils payload as String
       response = RestUtils.performPost("https://reqres.in/api/users","{\n" +
               "    \"name\": \"morpheus\",\n" +
               "    \"job\": \"leader\"\n" +
               "}", new HashMap<>());
        Assert.assertEquals(response.statusCode(),201);

        //using method from RestUtils payload as Map
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("name","ABC");
        userDetails.put("job","Tester");
        response = RestUtils.performPost("https://reqres.in/api/users",userDetails, new HashMap<>());
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void createUsers1() {
        //fetching payload from Payload package as Map
        Response response = RestUtils.performPost("https://reqres.in/api/users",
                CreateUsersPayload.get("XYZ","Automation Tester"),
                new HashMap<>());
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void createUsersFromReqResApi() {
        //here we have created wrapper class ReqResApi and hiding request details from testclass
       Response response = ReqResApi.getInstance().createUsers(
               CreateUsersPayload.get("XYZ","Automation Tester"));
        Assert.assertEquals(response.statusCode(),201);
    }


}
