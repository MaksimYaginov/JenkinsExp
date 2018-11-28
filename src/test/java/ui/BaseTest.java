package ui;

import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected final static int IMPLICITY_WAIT = 10;
    protected final static String WAY_TO_AUTOMATION_URL = "http://way2automation.com/way2auto_jquery/index.php";

    @BeforeSuite(description = "Задать настройки браузера")
    public void setBrowserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
    }
}
