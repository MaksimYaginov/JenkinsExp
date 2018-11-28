package ui;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

public class BaseUITest implements IHookable {

    protected WebDriver driver;
    protected final static int IMPLICITY_WAIT = 10;
    protected final static String WAY_TO_AUTOMATION_URL = "http://way2automation.com/way2auto_jquery/index.php";

    @BeforeSuite(description = "Задать настройки браузера")
    public void setBrowserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
    }

    @Override
    public final void run(final IHookCallBack callBack,
                          final ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            takeScreenShot(testResult.getMethod().getMethodName());
        }
    }

    @Attachment(value = "Failure in method {methodName}", type = "image/png")
    private byte[] takeScreenShot(final String methodName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
