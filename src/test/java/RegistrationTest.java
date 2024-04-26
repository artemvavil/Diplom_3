import io.qameta.allure.junit4.DisplayName;
import json.LoginCard;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class RegistrationTest extends StartQuitTest {
    Steps steps;

    @Before
    public void up(){
        registrationPage.openRegistrationPage();
        loginCard = new LoginCard(registrationCard.getEmail(), registrationCard.getPassword());
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationTest() {
        registrationPage.registration(registrationCard.getName(), registrationCard.getEmail(), registrationCard.getPassword());
        steps.apiAuth(200, "user.email", loginCard.getEmail());
        deleteApi.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void wrongPasswordRegTest() {
        registrationPage.registration(registrationCard.getName(), registrationCard.getEmail(), registrationCard.getPassword().substring(0, 5));
        assertTrue(registrationPage.wrongPasswordVisible());
    }
}
