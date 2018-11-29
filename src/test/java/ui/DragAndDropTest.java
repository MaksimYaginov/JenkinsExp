package ui;

import helpers.Helper;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.DroppablePage;
import pages.Way2AutomationPage;

import java.util.concurrent.TimeUnit;

public class DragAndDropTest extends BaseUITest {

    private DroppablePage droppablePage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    private final String expectedDroppableText = "Dropped!";

    @BeforeMethod(description = "Открыть браузер")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        driver.get(WAY_TO_AUTOMATION_URL);
        driver.manage().window().maximize();
    }

    @Feature("Way2Automation")
    @Story("DragAndDrop")
    @Test(description = "dragAndDropTest")
    public void dragAndDropTest() {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(Helper.generateString(), Helper.generateString(),
                Helper.generateString() + "@test", Helper.generateString(), Helper.generateString(),
                Helper.generateString());
        droppablePage = way2AutomationPage.goToDroppablePage()
                .dragAndDrop();

        Assert.assertEquals(droppablePage.getDroppableElementText(), expectedDroppableText);
    }

    @AfterMethod(description = "Закрыть браузер", alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
