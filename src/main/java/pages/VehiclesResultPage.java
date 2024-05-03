package pages;

import drivermanager.DriverManager;
import enums.Engines;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class VehiclesResultPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(),'Շարժիչ')]/..//div[@class = 'i']")
    WebElement engineInfo;
    @FindBy(xpath = "//*[@id='contentr']/div[4]/div[1]/a")
    List<WebElement> results;


    public VehiclesResultPage openPost(int count) {
        for (int i = 1; i <= count; i++) {
            try {
                Thread.sleep(2000);
                clickOnElement(results.get(i));
            } catch (Exception et) {
            }
        }
        return this;
    }

    public boolean checkResult() {
        ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        for (int i = 0; i <= tabs.size(); i++) {
            String value = engineInfo.getText();
            DriverManager.getDriver().switchTo().window(tabs.get(i));
            if (engineInfo.getText().equals(Engines.getElementByValue(value))) {

                return true;
            }
        }return false;
    }
}
