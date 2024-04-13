import io.qameta.allure.Step;
import io.restassured.response.Response;
import clientApi.PostApi;
import io.restassured.specification.Argument;
import json.LoginCard;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

public class Steps {
    LoginCard loginCard;
    PostApi postApi = new PostApi();
    String accessToken;

    @Step("Авторизация")
    public void apiAuth(int statusCode, String bodyParm, String equalTo) {
        Response response = postApi.authorization(loginCard);
        accessToken = response.getBody().path("accessToken");
        response.then().statusCode(statusCode)
                .and().assertThat().body(bodyParm, equalTo(equalTo));
    }
}
