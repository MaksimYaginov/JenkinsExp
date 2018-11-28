package ui;

import helpers.Helper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.AlertPage;
import pages.Way2AutomationPage;

import java.util.concurrent.TimeUnit;

public class AlertTest extends BaseUITest {

    private AlertPage alertPage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    private final String alertText = "Autotest alert";

    @BeforeMethod(description = "Открыть браузер")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(WAY_TO_AUTOMATION_URL);
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

        Assert.assertTrue(!alertPage.getTextFromAlert().equals( String.format("Hello %s! How are you today?", alertText)));
    }

    @AfterTest(description = "Закрыть браузер", alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
