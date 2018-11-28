package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Way2automationMenuPage {

    private WebDriver driver;

    private By menuWithSubMenuButton = By.cssSelector("ul.responsive-tabs li:nth-child(2)");

    private By iframe = By.xpath("//div[@id='example-1-tab-2']//iframe");

    private By delphiButton = By.id("ui-id-8");

    private By delphiSubmenu = By.xpath("//li[@id='ui-id-8']//li");

    public Way2automationMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenuWithSubMenuButton() {
        driver.findElement(menuWithSubMenuButton).click();
    }

    @Step("moveToDelphiButton")
    public void moveToDelphiButton() {
        driver.switchTo().frame(driver.findElement(iframe));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(delphiButton)).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(delphiSubmenu)));
    }

    @Step("delphiSubmenuIsPresent")
    public boolean delphiSubmenuIsPresent() {
        boolean coursesTypesIsPresent = false;
        List<WebElement> coursesTypesElements = driver.findElements(delphiSubmenu);
        for (WebElement coursesTypesElement : coursesTypesElements) {
            coursesTypesIsPresent = coursesTypesElement.isDisplayed();
        }
        return coursesTypesIsPresent;
    }
}
