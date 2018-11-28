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
import pages.Way2AutomationMenuPage;
import ui.BaseTest;

import java.util.concurrent.TimeUnit;

public class CursorTest extends BaseTest {

    private WebDriver driver;

    private Way2AutomationMenuPage way2AutomationMenuPage;
    private RegistrationFrom startPage;
    private Way2AutomationPage way2AutomationPage;


    @BeforeMethod(description = "Открыть браузер")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
    }

    @Test(description = "cursorTest")
    private void cursorTest() throws InterruptedException {
        startPage = new RegistrationFrom(driver);

        way2AutomationPage = startPage.registration(Helper.generateString(), Helper.generateString(), Helper.generateString() + "@test",
                Helper.generateString(), Helper.generateString(), Helper.generateString());
        way2AutomationMenuPage = way2AutomationPage.goToWay2automationMenuPage()
                .clickOnMenuWithSubMenuButton()
                .moveToDelphiButton();

        Assert.assertTrue(way2AutomationMenuPage.delphiSubmenuIsPresent());
    }

    @AfterTest(description = "Закрыть браузер", alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}