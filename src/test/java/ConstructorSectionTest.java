import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorSectionTest extends StartQuitTest {

    @Before
    public void up() {
        mainPage.openMainPage();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    public void bunTransitionTest() {
        mainPage.clickSauceHeading();
        mainPage.clickBunHeading();
        assertTrue(mainPage.bunSelected());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void sauceTransitionTest() {
        mainPage.clickSauceHeading();
        assertTrue(mainPage.sauceSelected());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    public void fillingsTransitionTest() {
        mainPage.clickFillingsHeading();
        assertTrue(mainPage.fillingsSelected());
    }
}
