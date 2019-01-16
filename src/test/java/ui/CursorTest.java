package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.Way2AutomationPage;
import pages.MenuPage;
import ui.base.BaseWay2AutomationUITest;

import static helpers.Helper.generateString;

public class CursorTest extends BaseWay2AutomationUITest {

    private MenuPage menuPage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    @Feature("Way2Automation")
    @Story("Cursor")
    @Test(description = "Smoke cursor test")
    public void cursorTest() {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(generateString(), generateString(),
                generateString() + "@test", generateString(), generateString(), generateString());
        menuPage = way2AutomationPage.goToMenuPage()
                .clickOnMenuWithSubMenuButton()
                .moveToDelphiButton();

        Assert.assertTrue(menuPage.delphiSubmenuIsPresent());
    }
}