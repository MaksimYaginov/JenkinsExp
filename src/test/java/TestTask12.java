import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.StartPage;
import pages.Way2automationMenuPage;

import java.util.concurrent.TimeUnit;

public class TestTask12 {

    private WebDriver driver;

    Way2automationMenuPage way2automationMenuPage;
    StartPage startPage;
    
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
        driver.manage().window().maximize();
    }

    @Test
    private void cursorTest() {
        startPage = new StartPage(driver);

        startPage.registration();
        way2automationMenuPage = startPage.goToWay2automationMenuPage();
        way2automationMenuPage.clickOnMenuWithSubMenuButton();
        way2automationMenuPage.moveToDelphiButton();
        Assert.assertTrue(way2automationMenuPage.delphiSubmenuIsPresent());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}