import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ProfileTest extends StartQuitTest {
    @Before
    public void up(){
        accessToken = postApi.registration(registrationCard).getBody().path("accessToken");
        loginPage.openLoginPage();
        loginPage.login(registrationCard.getEmail(), registrationCard.getPassword());
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет».")
    public void personalTransitionTest() {
        mainPage.clickPersonalAccountButton();
        assertTrue(profilePage.isKeyTitleDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    public void constructTransitionTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.clickConstructorButton();
        assertTrue(mainPage.makeBurgerTitleDisplayed());
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers")
    public void logoTransitionTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogo();
        assertTrue(mainPage.makeBurgerTitleDisplayed());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void exitTransitionTest() {
        mainPage.clickPersonalAccountButton();
        profilePage.clickExitButton();
        assertTrue(loginPage.loginButtonDisplayed());
    }
}
