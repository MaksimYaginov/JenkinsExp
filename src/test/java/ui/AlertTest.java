package ui;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.AlertPage;
import pages.MenuPage;
import pages.Way2AutomationPage;

import java.util.concurrent.TimeUnit;

public class AlertTest extends BaseTest {

    private WebDriver driver;
    private AlertPage alertPage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    private final String alertText = "Autotest alert";

    @BeforeMethod(description = "Открыть браузер")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
    }

    @Test(description = "alertTest")
    private void alertTest() throws InterruptedException {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(Helper.generateString(), Helper.generateString(), Helper.generateString() + "@test",
                Helper.generateString(), Helper.generateString(), Helper.generateString());
        alertPage = way2AutomationPage.goToAlertPage()
                .clickOnInputAlertButton()
                .clickOnInputBoxButton()
                .setTextInAlert(alertText);

        Assert.assertEquals(alertPage.getTextFromAlert(), String.format("Hello %s! How are you today?", alertText));
    }

    @AfterTest(description = "Закрыть браузер", alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
