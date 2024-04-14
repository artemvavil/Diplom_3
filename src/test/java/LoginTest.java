import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends StartQuitTest {

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void mainPageRegistrationTest(){
        accessToken = postApi.registration(registrationCard).getBody().path("accessToken");
        mainPage.openMainPage();
        mainPage.clickEnterButton();
        loginPage.login(registrationCard.getEmail(), registrationCard.getPassword());
        assertEquals(registrationCard.getEmail(),getApi.apiGetUser(accessToken));
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void personalAccountRegistrationTest(){
        accessToken = postApi.registration(registrationCard).getBody().path("accessToken");
        mainPage.openMainPage();
        mainPage.clickPersonalAccountButton();
        loginPage.login(registrationCard.getEmail(), registrationCard.getPassword());
        assertEquals(registrationCard.getEmail(),getApi.apiGetUser(accessToken));
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void formRegistrationTest(){
        accessToken = postApi.registration(registrationCard).getBody().path("accessToken");
        loginPage.openLoginPage();
        loginPage.login(registrationCard.getEmail(), registrationCard.getPassword());
        assertEquals(registrationCard.getEmail(),getApi.apiGetUser(accessToken));
    }
    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void forgotPageRegistrationTest(){
        accessToken = postApi.registration(registrationCard).getBody().path("accessToken");
        forgotPasswordPage.openForgotPage();
        forgotPasswordPage.clickLoginButton();
        loginPage.login(registrationCard.getEmail(), registrationCard.getPassword());
        assertEquals(registrationCard.getEmail(),getApi.apiGetUser(accessToken));
    }
}
