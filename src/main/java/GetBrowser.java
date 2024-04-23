import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetBrowser {
    public WebDriver getWebDriver() {
        String browserName = getBrowserName();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        switch (browserName) {
            case "chrome":
                System.out.println("Chrome browser selected.");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex":
                System.out.println("Yandex browser selected.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                return new ChromeDriver(options);
            default:
                System.out.println("Wrong browser name!");
                System.out.println("Type \"chrome\" or \"yandex\" in project file.");
                return null;
        }
    }


    private String getBrowserName (){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/project.properties");
            property.load(fis);

            return property.getProperty("browser");

        } catch (IOException e) {
            System.err.println("ERROR! No property file!");
            return null;
        }
    }
}
