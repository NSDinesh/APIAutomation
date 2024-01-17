package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private RestUtils(){

    }

    public static Response performPost(String endpoint, String requestPayload, Map<String,String> headers) {
       return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload)
                .post()
                .then().log().all().extract().response();
    }

    public static Response performPost(String endpoint, Map<String,String> requestPayload, Map<String,String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload)
                .post()
                .then().log().all().extract().response();
    }

}
