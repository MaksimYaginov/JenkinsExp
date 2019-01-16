package ui.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseGoogleUITest extends BaseUITest {

    private final static String GOOGLE__URL = "http://google.com/";

    @BeforeMethod(description = "Open browser")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(GOOGLE__URL);
        driver.manage().window().maximize();
    }

    @AfterMethod(description = "Close browser", alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
