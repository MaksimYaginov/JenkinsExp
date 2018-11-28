package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected final static int IMPLICITY_WAIT = 10;

    @BeforeSuite(description = "Задать настройки браузера")
    public void setBrowserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
    }
}
