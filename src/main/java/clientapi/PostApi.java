package clientapi;

import constants.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PostApi extends BaseClient {
    public Response doPost(String path, Object body) {
        return postRequest(path, body).thenReturn();
    }

    @Step("Авторизация")
    public Response authorization(Object loginCard) {
        Response response = doPost(Endpoints.LOGIN, loginCard);
        return response;
    }

    @Step("Регистрация")
    public Response registration(Object registerCard) {
        Response response = doPost(Endpoints.REGISTER, registerCard);
        return response;
    }
}