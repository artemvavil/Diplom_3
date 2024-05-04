import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import json.LoginCard;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends StartQuitTest {

    @Before
    public void up(){
        registrationPage.openRegistrationPage();
        loginCard = new LoginCard(registrationCard.getEmail(), registrationCard.getPassword());
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationTest() {
        registrationPage.registration(registrationCard.getName(), registrationCard.getEmail(), registrationCard.getPassword());

        Response response = postApi.authorization(loginCard);
        accessToken = response.getBody().path("accessToken");
        response.then().statusCode(200)
                .and().assertThat().body("user.email", equalTo(loginCard.getEmail()));
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void wrongPasswordRegTest() {
        registrationPage.registration(registrationCard.getName(), registrationCard.getEmail(), registrationCard.getPassword().substring(0, 5));
        assertTrue(registrationPage.wrongPasswordVisible());
    }
}
