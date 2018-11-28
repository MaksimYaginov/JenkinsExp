package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.CustomSeleniumMethods.clickButton;
import static helpers.Helper.moveToElement;
import static helpers.Waiters.waitUntilElementClickable;

public class Way2AutomationPage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[@id='toggleNav']//a[text()='Widget']")
    private WebElement widgetLink;

    @FindBy(xpath = "//ul[@id='toggleNav']//a[text()='Menu']")
    private WebElement widgetSubmenuMenu;

    public Way2AutomationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("goToWay2AutomationMenuPage")
    Way2AutomationMenuPage goToWay2automationMenuPage() {
        waitUntilElementClickable(driver, widgetLink);
        moveToElement(driver, widgetLink);
        clickButton(driver, widgetSubmenuMenu);

        return new Way2AutomationMenuPage(driver);
    }
}
