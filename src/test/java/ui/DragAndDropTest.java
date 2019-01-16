package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageElements.RegistrationFrom;
import pages.DroppablePage;
import pages.Way2AutomationPage;
import ui.base.BaseWay2AutomationUITest;

import static helpers.Helper.generateString;

public class DragAndDropTest extends BaseWay2AutomationUITest {

    private DroppablePage droppablePage;
    private RegistrationFrom registrationFrom;
    private Way2AutomationPage way2AutomationPage;

    private final String expectedDroppableText = "Dropped!";

    @Feature("Way2Automation")
    @Story("DragAndDrop")
    @Test(description = "Smoke drag and drop test")
    public void dragAndDropTest() {
        registrationFrom = new RegistrationFrom(driver);

        way2AutomationPage = registrationFrom.registration(generateString(), generateString(),
                generateString() + "@test", generateString(), generateString(), generateString());
        droppablePage = way2AutomationPage.goToDroppablePage()
                .dragAndDrop();

        Assert.assertEquals(droppablePage.getDroppableElementText(), expectedDroppableText);
    }
}
