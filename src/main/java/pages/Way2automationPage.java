package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Way2automationPage {

    private WebDriver driver;

    private By coursesButton = By.cssSelector("li.dropdown:nth-child(3)");

    private By jmeterCourseButton = By.cssSelector("li.dropdown:nth-child(3) li:nth-child(4)");

    private By coursesTypes = By.cssSelector("li.dropdown:nth-child(3) li");

    public Way2automationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToCoursesButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(coursesButton)).build().perform();
    }

    public void moveToJmeterCourse() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(jmeterCourseButton)).build().perform();
    }

    public boolean coursesTypesIsPresent() {
        boolean coursesTypesIsPresent = false;
        List<WebElement> coursesTypesElements = driver.findElements(coursesTypes);
        for (WebElement coursesTypesElement : coursesTypesElements) {
            coursesTypesIsPresent = coursesTypesElement.isDisplayed();
        }
        return coursesTypesIsPresent;
    }
}
