package Filters;

import enums.Region;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

public class BaseFilterBar extends BasePage {
    @FindBy(xpath = "//*[@id='idprice1']")
    WebElement priceF;
    @FindBy(xpath = "//*[@id='idprice2']")
    WebElement priceT;
    @FindBy(xpath = "(//div[@class='me'])[1]")
    WebElement regionDropdown;
    @FindBy(xpath = "//*[@id='ff']/div[1]/div/div[2]/div[2]/div")
    List<WebElement> regionList;

    protected WebDriver driver;

    public FilterBarRealEstate chooseRegion(Region region) {
        clickOnElement(regionDropdown);
        for (WebElement e : regionList) {
            String elementText = e.getText();
            if (region.equals(Region.getElementByValue(elementText))) {
                clickOnElement(e);
                return new FilterBarRealEstate();
            }
        }
        System.out.println("Region not found in the list.");
        return null;
    }
    public BaseFilterBar choosePriceRange(int priceFrom, int priceTo) {
        try {
            Thread.sleep(2000);
            fillInput(priceF, String.valueOf(priceFrom));
            fillInput(priceT, String.valueOf(priceTo));
            return this;
        }catch (Exception e){}

        return null;
    }

}
