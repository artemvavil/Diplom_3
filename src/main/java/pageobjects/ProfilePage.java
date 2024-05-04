package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;
    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private WebElement logo;
    @FindBy(xpath = "//li/..//p[text()='Конструктор']")
    private WebElement constructorButton;
    @FindBy(xpath = "//button[contains(text(),'Выход')]")
    private WebElement exitButton;
    @FindBy(xpath = "//p[@class='Account_text__fZAIn text text_type_main-default']")
    private WebElement keyText;

    //Steps
    @Step("Нажать на логотип Stellar Burgers")
    public void clickLogo(){
        logo.click();
    }
    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton(){
        constructorButton.click();
    }
    @Step ("Нажать на кнопку Выход")
    public void clickExitButton(){
        exitButton.click();
    }


    public boolean isKeyTitleDisplayed(){
        return keyText.isDisplayed();
    }
}
