package ui;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.Way2AutomationPage;
import pages.MenuPage;

import java.util.concurrent.TimeUnit;

public class CursorTest extends BaseTest {

    private WebDriver driver;

    private MenuPage menuPage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;


    @BeforeMethod(description = "Открыть браузер")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(WAY_TO_AUTOMATION_URL);
        driver.manage().window().maximize();
    }

    @Test(description = "cursorTest")
    private void cursorTest() throws InterruptedException {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(Helper.generateString(), Helper.generateString(), Helper.generateString() + "@test",
                Helper.generateString(), Helper.generateString(), Helper.generateString());
        menuPage = way2AutomationPage.goToMenuPage()
                .clickOnMenuWithSubMenuButton()
                .moveToDelphiButton();

        Assert.assertTrue(menuPage.delphiSubmenuIsPresent());
    }

    @AfterTest(description = "Закрыть браузер", alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}