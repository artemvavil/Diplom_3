
import io.github.bonigarcia.wdm.WebDriverManager;
import json.LoginCard;
import json.RegistrationCard;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import clientApi.DeleteApi;
import clientApi.GetApi;
import clientApi.PostApi;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

public class StartQuitTest {
    WebDriver driver;
    DeleteApi deleteApi = new DeleteApi();
    RegistrationCard registrationCard;
    GetApi getApi = new GetApi();
    PostApi postApi = new PostApi();
    LoginPage loginPage;
    MainPage mainPage;
    ForgotPasswordPage forgotPasswordPage;
    RegistrationPage registrationPage;
    LoginCard loginCard;
    String accessToken;
    ProfilePage profilePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

        registrationCard = new RegistrationCard(
                "test_user" + RandoIndex.getRandomIndex() + "@a.com",
                RandoIndex.getRandomIndex(),
                "test_user" + RandoIndex.getRandomIndex());
    }

    @After
    public void cleanUp() {
        driver.quit();
        deleteApi.deleteUser(accessToken);
    }
}
