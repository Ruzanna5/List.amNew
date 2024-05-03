package Filters;

import enums.Engines;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.VehiclesResultPage;

import java.util.List;

public class FilterBarVehicles extends BasePage {
    @FindBy(xpath = "//input[@id='_id_a15']/following-sibling::div[@class='me']")
    WebElement engineDropdown;
    @FindBy(xpath = "//div[@class='l ms top']/div[@class = 'i']")
    List<WebElement> engineTypeList;
    @FindBy(xpath = "//*[@id='ff']/div[7]/div[2]/div[2]/div/div[2]/div[5]/div[1]")
    WebElement chooseButton;

    public FilterBarVehicles openEngineDropdown(){
        try {
        Thread.sleep(3000);
        }catch (Exception e){}
        clickOnElement(engineDropdown);
        return this;
    }
    public VehiclesResultPage chooseEngineType(Engines engin) {
        for (WebElement e : engineTypeList) {
            String elementText = e.getText();
            if (engin.getValue().equals(elementText)) {
                e.click();
                clickOnElement(chooseButton);
                return new VehiclesResultPage();
            }
        }
        System.out.println("Engine not found in the list.");
        return null;
    }
}
