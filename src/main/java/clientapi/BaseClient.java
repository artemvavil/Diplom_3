package clientapi;

import constants.URL;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseClient {

    protected Response getRequest(String path, String token) {
        return RestAssured.given()
                .header("Authorization", token)
                .spec(baseRequestSpec())
                .when()
                .get(path)
                .thenReturn();
    }

    protected Response postRequest(String path, Object body) {
        return RestAssured.given()
                .spec(baseRequestSpec())
                .body(body)
                .when()
                .post(path)
                .thenReturn();
    }

    protected Response deleteRequest(String path, String token) {
        return RestAssured.given()
                .header("Authorization", token)
                .spec(BaseClient.baseRequestSpec())
                .delete(path)
                .thenReturn();
    }

    private static RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(URL.MAIN_PAGE_URL)
                .addHeader("Content-Type", "application/json")
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

}
