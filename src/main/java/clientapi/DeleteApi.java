package clientapi;

import constants.Endpoints;

public class DeleteApi extends BaseClient {
    public void deleteUser(String token) {
        if (token != null) {
            deleteRequest(Endpoints.USER, token)
                    .then().statusCode(202);
        }
    }
}
