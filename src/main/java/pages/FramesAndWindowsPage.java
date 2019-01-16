package pages;

import helpers.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.CustomSeleniumMethods.clickButton;
import static helpers.Helper.switchToFrame;

public class FramesAndWindowsPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Open Multiple Windows']")
    private WebElement openMultipleWindowsButton;

    @FindBy(xpath = "//div[@id='example-1-tab-4']//iframe")
    private WebElement iframe;

    @FindBy(xpath = "//div[@class='farme_window']//a[text()='Open multiple pages']")
    private WebElement openMultiplePagesLink;

    @FindBy(xpath = "//a[contains(text(),'Open Window')]")
    private WebElement openWindowLink;

    FramesAndWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMultipleWindowsButtonClick() {
        clickButton(driver, openMultipleWindowsButton);
    }

    public void openMultiplePagesLinkclick() {
        switchToFrame(driver, iframe);
        clickButton(driver, openMultiplePagesLink);
    }

    public void switchToNewTab(Integer tabNumber) {
        driver.switchTo().window(Helper.getAllOpenTabs(driver).get(tabNumber));
    }

    public void openWindowLinkClick() {
        clickButton(driver, openWindowLink);
    }

    public boolean newTabIsOpen(Integer tabNumberBefore, Integer tabNumberAfter) {
        return tabNumberAfter.equals(tabNumberBefore + 1);
    }
}
