import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Way2automationPage;

import java.util.concurrent.TimeUnit;

public class TestTask12 {

    private WebDriver driver;

    Way2automationPage way2automationPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/");
        driver.manage().window().maximize();
    }

    @Test
    private void cursorTest() {
        way2automationPage = new Way2automationPage(driver);

        way2automationPage.moveToCoursesButton();
        way2automationPage.moveToJmeterCourse();
        Assert.assertTrue(way2automationPage.coursesTypesIsPresent());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}