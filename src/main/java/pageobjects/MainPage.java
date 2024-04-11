package pageobjects;

import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//p[contains(text(),'Личный Кабинет')]")
    private WebElement personalAccountButton; // кнопка "Личный кабинет"
    @FindBy(css = ".text.text_type_main-larg" +
            "e.mb-5.mt-10")
    private WebElement makeBurgerTitle; //надпись соберите бургер
    @FindBy(css=".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg")
    private WebElement enterButton; //кнопка "войти в аккаунт"
    @FindBy(xpath = "//div//span[text()='Булки']")
    private WebElement bunTitle;
    @FindBy(xpath = "//div//span[text()='Соусы']")
    private WebElement sauceTitle;
    @FindBy(xpath = "//div//span[text()='Начинки']")
    private WebElement fillingsTitle;

//Steps
    @Step("Нажать кнопку Булки")
    public void clickBunTitle(){
        bunTitle.click();
    }
    @Step("Нажать кнопку Соусы")
    public void clickSauceTitle(){
        sauceTitle.click();
    }
    @Step("Нажать кнопку Булки")
    public void clickFillingsTitle(){
        fillingsTitle.click();
    }
    public boolean makeBurgerTitleDisplayed(){
        return  makeBurgerTitle.isDisplayed();
    }
    @Step("Нажать кнопку Войти в аккаунт")
    public void clickEnterButton(){
        enterButton.click();
    }
    @Step("Нажать кнопку Личный кабинет")
    public void clickPersonalAccountButton(){
        personalAccountButton.click();
    }
    @Step("Открыть главную страницу")
    public void openMainPage(){
        driver.get(URL.MAIN_PAGE_URL);
    }
}
