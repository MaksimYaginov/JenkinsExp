package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartGooglePage;
import ui.base.BaseGoogleUITest;

import static helpers.JavascriptExecutorHelper.scrollIsVisible;
import static helpers.JavascriptExecutorHelper.unfocusElement;
import static helpers.JavascriptExecutorHelper.waitForLoadingPage;

public class JsExecutorTest extends BaseGoogleUITest {

    private StartGooglePage startGooglePage;

    @Feature("Google")
    @Story("JsExecutor")
    @Test(description = "Smoke js executor test")
    private void jsExecutorTest() {
        startGooglePage = new StartGooglePage(driver);

        Assert.assertTrue(!scrollIsVisible(driver));

        startGooglePage.inputSearchText("cat");
        unfocusElement(driver);
        startGooglePage.clickOnSearchButton();
        waitForLoadingPage(driver, IMPLICITY_WAIT);

        Assert.assertTrue(scrollIsVisible(driver));
    }
}
