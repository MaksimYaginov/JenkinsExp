package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {

    private final static int explicitlyWait = 10;

    public static void waitUntilAllElementsVisible(WebDriver driver, List<WebElement> webElements) {
        new WebDriverWait(driver, explicitlyWait).until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public static void waitUntilElementVisible(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, explicitlyWait).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementClickable(WebDriver driver, WebElement webElement) {
        new WebDriverWait(driver, explicitlyWait).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilElementLocatedByInvisible(WebDriver driver, By webElementLocator) {
        new WebDriverWait(driver, explicitlyWait).until(ExpectedConditions.invisibilityOfElementLocated(webElementLocator));
    }

    public static void waitUntilElementLocatedByVisible(WebDriver driver, By webElementLocator) {
        new WebDriverWait(driver, explicitlyWait).until(ExpectedConditions.visibilityOfElementLocated(webElementLocator));
    }

    public static void waitUntilElementLocatedByClickable(WebDriver driver, By webElementLocator) {
        new WebDriverWait(driver, explicitlyWait).until(ExpectedConditions.elementToBeClickable(webElementLocator));
    }
}
