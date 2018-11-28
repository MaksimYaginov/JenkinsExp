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

    @FindBy(xpath = "//ul[@id='toggleNav']//a[text()='Alert']")
    private WebElement alertLink;

    @FindBy(xpath = "//ul[@id='toggleNav']//a[text()='Menu']")
    private WebElement widgetSubmenuMenu;

    public Way2AutomationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("goToMenuPage")
    public MenuPage goToMenuPage() {
        waitUntilElementClickable(driver, widgetLink);
        moveToElement(driver, widgetLink);
        clickButton(driver, widgetSubmenuMenu);

        return new MenuPage(driver);
    }

    @Step("goToAlertPage")
    public AlertPage goToAlertPage() {
        clickButton(driver, alertLink);

        return new AlertPage(driver);
    }
}
