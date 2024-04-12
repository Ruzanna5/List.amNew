package pages;

import drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected Actions actions;
    public WebDriverWait wait;


    public BasePage() {
        this.driver = DriverManager.getDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);
    }

    public void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillInput(WebElement element, String value) {
        clickOnElement(element);
        element.sendKeys(value);
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void scroll(WebElement element) {
        actions.moveToElement(element);
    }

}
