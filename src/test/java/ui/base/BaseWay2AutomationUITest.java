package ui.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseWay2AutomationUITest extends BaseUITest{

    private final static String WAY_TO_AUTOMATION_URL = "http://way2automation.com/way2auto_jquery/index.php";

    @BeforeMethod(description = "Open browser")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(WAY_TO_AUTOMATION_URL);
        driver.manage().window().maximize();
    }

    @AfterMethod(description = "Close browser", alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
