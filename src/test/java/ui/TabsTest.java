package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.FramesAndWindowsPage;
import pages.Way2AutomationPage;
import ui.base.BaseWay2AutomationUITest;

import static helpers.Helper.generateString;
import static helpers.Helper.getAllOpenTabs;

public class TabsTest extends BaseWay2AutomationUITest {

    private FramesAndWindowsPage framesAndWindowsPage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    private Integer tabNumberBefore, tabNumberAfter;

    @Feature("Way2Automation")
    @Story("Tabs")
    @Test(description = "Smoke tabs test")
    public void dragAndDropTest() {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(generateString(), generateString(),
                generateString() + "@test", generateString(), generateString(), generateString());
        framesAndWindowsPage = way2AutomationPage.goToFramesAndWindowsPage();

        framesAndWindowsPage.openMultipleWindowsButtonClick();
        framesAndWindowsPage.openMultiplePagesLinkclick();
        tabNumberBefore = getAllOpenTabs(driver).size();
        framesAndWindowsPage.switchToNewTab(1);
        framesAndWindowsPage.openWindowLinkClick();
        tabNumberAfter = getAllOpenTabs(driver).size();

        Assert.assertTrue(framesAndWindowsPage.newTabIsOpen(tabNumberBefore, tabNumberAfter));
    }
}
