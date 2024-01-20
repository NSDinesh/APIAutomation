package reqres.api;

import io.restassured.response.Response;
import reqres.payload.CreateUsersPayload;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class ReqResApi {

    private static ReqResApi reqResApi;
    public static ReqResApi getInstance() {
        if(reqResApi == null)
            return new ReqResApi();
        return reqResApi;
    }

    public Response createUsers(Map<String,Object> payload) {
        return RestUtils.performPost("https://reqres.in/api/users",
                CreateUsersPayload.get("XYZ","Automation Tester"),
                new HashMap<>());
    }
}
