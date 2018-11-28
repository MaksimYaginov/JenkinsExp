package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static helpers.CustomSeleniumMethods.clickButton;
import static helpers.Helper.inputTextInAlert;
import static helpers.Helper.switchToFrame;
import static helpers.Waiters.waitUntilElementVisible;
import static java.awt.SystemColor.text;

public class AlertPage {

    private WebDriver driver;

    @FindBy(xpath = "//iframe[@src='alert/input-alert.html']")
    private WebElement iframe;

    @FindBy(xpath = "//button[@onclick='myFunction()']")
    private WebElement demonstrateInputBoxButton;

    @FindBy(xpath = "//a[text()='Input Alert']")
    private WebElement inputAlertButton;

    @FindBy(id = "demo")
    private WebElement alertFieldText;

    AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("clickOnInputAlertButton")
    public AlertPage clickOnInputAlertButton() {
        clickButton(driver,inputAlertButton);

        return this;
    }

    @Step("clickOnInputBoxButton")
    public AlertPage clickOnInputBoxButton() {
        switchToFrame(driver, iframe);
        clickButton(driver, demonstrateInputBoxButton);

        return this;
    }

    @Step("setTextInAlert")
    public AlertPage setTextInAlert(String text) {
        inputTextInAlert(driver, text);

        return this;
    }

    @Step("getTextFromAlert")
    public String getTextFromAlert() {
        waitUntilElementVisible(driver, alertFieldText);

        return alertFieldText.getText();
    }
}
