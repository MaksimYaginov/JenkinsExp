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

    @FindBy(xpath = "//a[text()='Widget']")
    private WebElement widgetLink;

    @FindBy(xpath = "//a[text()='Alert']")
    private WebElement alertLink;

    @FindBy(xpath = "//a[text()='Menu']")
    private WebElement widgetMenu;

    @FindBy(xpath = "//a[text()='Interaction']")
    private WebElement interactionLink;

    @FindBy(xpath = "//a[text()='Droppable']")
    private WebElement interactionDroppable;

    @FindBy(xpath = "//a[text()='Frames and Windows']")
    private WebElement framesAndWindowsButton ;

    public Way2AutomationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Go to Menu Page")
    public MenuPage goToMenuPage() {
        waitUntilElementClickable(driver, widgetLink);
        moveToElement(driver, widgetLink);
        clickButton(driver, widgetMenu);

        return new MenuPage(driver);
    }

    @Step("Go to Alert Page")
    public AlertPage goToAlertPage() {
        clickButton(driver, alertLink);

        return new AlertPage(driver);
    }

    @Step("Go to Droppable Page")
    public DroppablePage goToDroppablePage() {
        waitUntilElementClickable(driver, interactionLink);
        moveToElement(driver, interactionLink);
        clickButton(driver, interactionDroppable);

        return new DroppablePage(driver);
    }

    @Step("Go to Frames and Windows Page")
    public FramesAndWindowsPage goToFramesAndWindowsPage() {
        waitUntilElementClickable(driver, framesAndWindowsButton);
        clickButton(driver, framesAndWindowsButton);

        return new FramesAndWindowsPage(driver);
    }
}
