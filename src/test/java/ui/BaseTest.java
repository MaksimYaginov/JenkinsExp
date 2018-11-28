package ui;

import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected final static int IMPLICITY_WAIT = 10;

    @BeforeSuite(description = "Задать настройки браузера")
    public void setBrowserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
    }
}
