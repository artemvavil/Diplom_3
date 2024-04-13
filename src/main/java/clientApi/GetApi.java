package clientApi;

import constants.Endpoints;

public class GetApi extends BaseClient {
    public String apiGetUser(String accessToken) {
        return getRequest(Endpoints.USER, accessToken).getBody().path("user.email");
    }
}
