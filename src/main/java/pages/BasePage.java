package pages;

import drivermanager.DriverManager;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BasePage {

    protected final WebDriver driver;
    protected Actions actions;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;


    public BasePage() {
        this.driver = DriverManager.getDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(this.driver, this);
        javascriptExecutor = (JavascriptExecutor) driver;

    }

    public void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void clickOnElement(WebElement element) {
        waitUntilElementClickable(element);
        element.click();
    }

    public void fillInput(WebElement element, String value) {
        clickOnElement(element);
        element.sendKeys(value);
    }
    public void fillInput(WebElement element, String value,String value1) {
        clickOnElement(element);
        element.sendKeys(value+" "+value1);
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void scroll(WebElement element) {
        actions.moveToElement(element);
    }

    public void switchToIframe(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToTab(int number) {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(number));
    }
}
