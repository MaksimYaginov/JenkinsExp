package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.CustomSeleniumMethods.clickButton;
import static helpers.CustomSeleniumMethods.sendKeysIntoField;
import static helpers.Helper.moveToElement;
import static helpers.Waiters.waitUntilElementVisible;

public class StartGooglePage {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class,'FPdoLc')]//input[@name='btnK']")
    private WebElement searchButton;

    public StartGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StartGooglePage inputSearchText(String text) {
        sendKeysIntoField(driver, searchField, text);

        return this;
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
