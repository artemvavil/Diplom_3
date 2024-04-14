package pageobjects;

import constants.URL;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement loginButton; // кнопка Войти
    @FindBy(xpath = "//input[@name='name']")
    private WebElement emailInput; // поле ввода email
    @FindBy(xpath = "//input[@name='Пароль']")
    private WebElement passwordInput; // поле ввода email


    //Steps
    @Step("Авторизоваться")
    public void clickLoginButton(){
        loginButton.click();
    }
    @Step("Ввести email")
    public void inputEmail(String email){
        emailInput.sendKeys(email);
    }
    @Step("Ввести пароль")
    public void inputPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void login(String email,String password){
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
    }
    @Step("Открыть страницу авторизации")
    public void openLoginPage(){
        driver.get(URL.LOGIN_PAGE_URL);
    }

    public boolean loginButtonDisplayed(){
        return loginButton.isDisplayed();
    }
}
