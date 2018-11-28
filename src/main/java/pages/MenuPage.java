package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static helpers.CustomSeleniumMethods.clickButton;
import static helpers.Helper.moveToElement;
import static helpers.Helper.switchToFrame;
import static helpers.Waiters.*;

public class MenuPage {

    private WebDriver driver;

    @FindBy(css = "ul.responsive-tabs li:nth-child(2)")
    private WebElement menuWithSubMenuButton;

    @FindBy(xpath = "//div[@id='example-1-tab-2']//iframe")
    private WebElement iframe;

    @FindBy(id = "ui-id-8")
    private WebElement delphiButton;

    @FindBy(xpath = "//li[@id='ui-id-8']//li")
    private List<WebElement> delphiSubmenu;

    MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("clickOnMenuWithSubMenuButton")
    public MenuPage clickOnMenuWithSubMenuButton() {
        clickButton(driver, menuWithSubMenuButton);

        return this;
    }

    @Step("moveToDelphiButton")
    public MenuPage moveToDelphiButton() {
        switchToFrame(driver, iframe);
        waitUntilElementVisible(driver, delphiButton);
        moveToElement(driver, delphiButton);
        waitUntilAllElementsVisible(driver, delphiSubmenu);

        return this;
    }

    @Step("delphiSubmenuIsPresent")
    public boolean delphiSubmenuIsPresent() {
        boolean coursesTypesIsPresent = false;

        for (WebElement delphiSubmenuElement : delphiSubmenu) {
            coursesTypesIsPresent = delphiSubmenuElement.isDisplayed();
        }

        return coursesTypesIsPresent;
    }
}
