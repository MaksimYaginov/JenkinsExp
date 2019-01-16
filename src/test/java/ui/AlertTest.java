package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.AlertPage;
import pages.Way2AutomationPage;
import ui.base.BaseWay2AutomationUITest;

import static helpers.Helper.generateString;

public class AlertTest extends BaseWay2AutomationUITest {

    private AlertPage alertPage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    private final String alertText = "Autotest alert";

    @Feature("Way2Automation")
    @Story("Alert")
    @Test(description = "Smoke alert test")
    public void alertTest() {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(generateString(), generateString(),
                generateString() + "@test", generateString(), generateString(), generateString());
        alertPage = way2AutomationPage.goToAlertPage()
                .clickOnInputAlertButton()
                .clickOnInputBoxButton()
                .setTextInAlert(alertText);

        Assert.assertEquals(alertPage.getTextFromAlert(), String.format("Hello %s! How are you today?", alertText));
    }
}
