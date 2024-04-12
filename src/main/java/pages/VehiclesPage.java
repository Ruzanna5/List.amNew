package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehiclesPage extends BasePage {
    @FindBy(xpath = "//div[@id = 'pt']")
    WebElement transportPageTitle;
    @FindBy(xpath = "//a[contains(text(),'Եվս 18')]")
    WebElement more18;
    @FindBy(xpath = "(//a[contains(text(),'Ավտոբուսներ')])[1]")
    WebElement buses;



    public String getTransportPageTitle() {
        return transportPageTitle.getText();
    }

    public BusesPage chooseBusFromList() {
        try {
            Thread.sleep(3000);

        } catch (Exception e) {
        }
        clickOnElement(more18);
        clickOnElement(buses);
        return new BusesPage();
    }
}
