package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Waiters.waitUntilElementClickable;

public class CustomSeleniumMethods {

    public static void clickButton(WebDriver driver, WebElement webElement){
        waitUntilElementClickable(driver,webElement);
        webElement.click();
    }

    public static void sendKeysIntoField(WebDriver driver, WebElement webElement, String string){
        waitUntilElementClickable(driver,webElement);
        webElement.sendKeys(string);
    }
}
