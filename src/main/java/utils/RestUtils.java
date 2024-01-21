package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ReportLogger;

import java.util.HashMap;
import java.util.Map;

public class RestUtils {

    private RestUtils(){

    }

    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String,String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload);
    }

    private static void printRequestDetailsInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ReportLogger.info("Endpoint is "+queryableRequestSpecification.getBaseUri());
        ReportLogger.info("Method is "+queryableRequestSpecification.getMethod());
        ReportLogger.info("Headers are "+queryableRequestSpecification.getHeaders().asList().toString());
        ReportLogger.info("Request body is "+queryableRequestSpecification.getBody());
    }

    private static void printResponseDetailsInReport(Response response) {
        ReportLogger.info("Status code is "+response.getStatusCode());
        ReportLogger.info("Response Headers are "+response.getHeaders().asList().toString());
        ReportLogger.info("Response body is "+response.getBody());
    }

    public static Response performPost(String endpoint, String requestPayload, Map<String,String> headers) {
      RequestSpecification requestSpecification = getRequestSpecification(endpoint,requestPayload,headers);
      Response response = requestSpecification.post().then().log().all().extract().response();
      printRequestDetailsInReport(requestSpecification);
      printResponseDetailsInReport(response);
      return response;
    }

    public static Response performPost(String endpoint, Map<String,Object> requestPayload, Map<String,String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint,requestPayload,headers);
        Response response = requestSpecification.post();
        printRequestDetailsInReport(requestSpecification);
        printResponseDetailsInReport(response);
        return response;
    }

}
