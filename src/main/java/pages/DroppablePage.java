package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static helpers.Helper.dragAndDropElements;
import static helpers.Helper.switchToFrame;
import static helpers.Waiters.waitUntilAllElementsVisible;
import static helpers.Waiters.waitUntilElementClickable;
import static helpers.Waiters.waitUntilElementVisible;

public class DroppablePage {

    private WebDriver driver;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "droppable")
    private WebElement droppableElement;

    @FindBy(id = "ui-id-8")
    private WebElement delphiButton;

    @FindBy(xpath = "//div[@id='example-1-tab-1']//iframe")
    private WebElement iframe;

    DroppablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Drag And Drop")
    public DroppablePage dragAndDrop() {
        switchToFrame(driver, iframe);
        waitUntilElementClickable(driver, draggableElement);
        waitUntilElementClickable(driver, droppableElement);
        dragAndDropElements(driver, draggableElement, droppableElement);

        return this;
    }

    @Step("Get Draggable Element Text")
    public String getDroppableElementText() {
        waitUntilElementVisible(driver, droppableElement);

        return droppableElement.getText();
    }
}
