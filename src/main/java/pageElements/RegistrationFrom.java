package pageElements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Way2AutomationPage;

import static helpers.CustomSeleniumMethods.clickButton;
import static helpers.CustomSeleniumMethods.sendKeysIntoField;
import static helpers.Waiters.*;

public class RegistrationFrom {

    private WebDriver driver;

    private By registrationFormLocator = By.id("load_box");

    private By nameField = By.name("name");

    private By phoneField = By.name("phone");

    private By emailField = By.name("email");

    private By cityField = By.name("city");

    private By usernameField = By.xpath("//form[@class='ajaxsubmit']//input[@name='username']");

    private By passwordField = By.xpath("//form[@class='ajaxsubmit']//input[@name='password']");

    private By submitButton = By.xpath("//form[@class='ajaxsubmit']//input[@type='submit']");

    public RegistrationFrom(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Registration")
    public Way2AutomationPage registration(String name, String phone, String email, String city, String userName, String password) {
        waitUntilElementLocatedByVisible(driver, registrationFormLocator);
        WebElement registrationFrom = driver.findElement(registrationFormLocator);

        sendKeysIntoField(driver,registrationFrom.findElement(nameField), name);
        sendKeysIntoField(driver,registrationFrom.findElement(phoneField), phone);
        sendKeysIntoField(driver,registrationFrom.findElement(emailField),email);
        sendKeysIntoField(driver,registrationFrom.findElement(cityField),city);
        sendKeysIntoField(driver,registrationFrom.findElement(usernameField),userName);
        sendKeysIntoField(driver,registrationFrom.findElement(passwordField),password);
        clickButton(driver,registrationFrom.findElement(submitButton));
        waitUntilElementLocatedByInvisible(driver, registrationFormLocator);

        return new Way2AutomationPage(driver);
    }
}
