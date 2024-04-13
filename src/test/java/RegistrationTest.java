import io.qameta.allure.junit4.DisplayName;
import json.LoginCard;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class RegistrationTest extends StartQuitTest {
    Steps steps;

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationTest() {
        registrationPage.openRegistrationPage();
        loginCard = new LoginCard(registrationCard.getEmail(), registrationCard.getPassword());
        registrationPage.registration(registrationCard.getName(), registrationCard.getEmail(), registrationCard.getPassword());
        steps.apiAuth(200, "user.email", loginCard.getEmail());
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    public void wrongPasswordRegTest() {
        registrationPage.openRegistrationPage();
        loginCard = new LoginCard(registrationCard.getEmail(), registrationCard.getPassword());

        registrationPage.registration(registrationCard.getName(), registrationCard.getEmail(), registrationCard.getPassword().substring(0, 5));//первые 5 символом пароля
        assertTrue(registrationPage.wrongPasswordVisible());
    }
}
