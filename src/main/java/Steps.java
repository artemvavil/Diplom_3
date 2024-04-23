import io.qameta.allure.Step;
import io.restassured.response.Response;
import clientapi.PostApi;
import json.LoginCard;

import static org.hamcrest.CoreMatchers.equalTo;

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
