package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptExecutorHelper {

    public static boolean scrollIsVisible(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Long scrollYValue = (Long) executor.executeScript("return window.scrollY;");
        return scrollYValue != 0;
    }

    public static void unfocusElement(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(
                "var tmp = document.createElement('input');" +
                        "document.body.appendChild(tmp);" +
                        "tmp.focus();" +
                        "document.body.removeChild(tmp);");
    }

    public static void waitForLoadingPage(WebDriver driver, Integer timeOut) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        new WebDriverWait(driver, timeOut).until((WebDriver webDriver) ->
                executor.executeScript("return document.readyState").equals("complete"));
    }

}
