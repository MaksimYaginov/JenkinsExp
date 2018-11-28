package helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Waiters.waitUntilElementClickable;

public class CustomSeleniumMethods {

    @Step("clickButton ({1})")
    public static void clickButton(WebDriver driver, WebElement webElement){
        waitUntilElementClickable(driver,webElement);
        webElement.click();
    }

    @Step("Send {2} into {1}")
    public static void sendKeysIntoField(WebDriver driver, WebElement webElement, String string){
        waitUntilElementClickable(driver,webElement);
        webElement.sendKeys(string);
    }
}
