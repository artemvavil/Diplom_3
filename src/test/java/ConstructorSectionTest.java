import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(mainPage.bunSelected(), "Булки");
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void sauceTransitionTest() {
        mainPage.clickSauceHeading();
        assertEquals("Соусы", mainPage.sauceSelected());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    public void fillingsTransitionTest() {
        mainPage.clickFillingsHeading();
        assertEquals("Начинки", mainPage.fillingsSelected());
    }
}
