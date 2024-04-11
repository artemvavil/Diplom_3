package pageobjects;

import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//label[text()='Имя']/..//input")
    private WebElement nameInput;
    @FindBy(xpath = "//label[text()='Email']/..//input")
    private WebElement emailInput; //
    @FindBy(xpath = "//label[text()='Пароль']/..//input")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Зарегистрироваться')]")
    private WebElement registerButton;
    @FindBy(xpath = "//p[@class='input__error text_type_main-default']")
    private WebElement wrongPasswordTitle;

    //Steps
    @Step("Ввести имя")
    public void nameInput(String name){
        nameInput.sendKeys(name);
    }
    @Step("Ввести email")
    public void emailInput(String email){
        emailInput.sendKeys(email);
    }
    @Step("Ввести пароль")
    public void passwordInput(String password){
        passwordInput.sendKeys(password);
    }
    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegistrationButton(){
        registerButton.click();
    }
    @Step("Отображение надписи Некорректный пароль")
    public boolean wrongPasswordVisible(){
        return wrongPasswordTitle.isDisplayed();
    }
    @Step("Открыть страницу регистрации")
    public void openRegistrationPage(){
        driver.get(URL.REGISTER_PAGE_URL);
    }
    public void registration(String name, String email,String password){
        nameInput(name);
        emailInput(email);
        passwordInput(password);
        clickRegistrationButton();
    }

}
