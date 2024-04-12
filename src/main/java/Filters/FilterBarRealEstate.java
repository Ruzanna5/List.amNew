package Filters;

import enums.Region;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.RealEstatePage;

import java.util.ArrayList;
import java.util.List;


public class FilterBarRealEstate extends RealEstatePage {
    @FindBy(xpath = "(//div[@class='me'])[1]")
    WebElement regionDropdown;
    @FindBy(xpath = "//*[@id='ff']/div[1]/div/div[2]/div[2]/div")
    List<WebElement> regionList;
    @FindBy(xpath = "//div[@class='bt']//div[@class = 'b1']")
    WebElement chooseButton;
    @FindBy(xpath = "//*[@id='idprice1']")
    WebElement priceF;
    @FindBy(xpath = "//*[@id='idprice2']")
    WebElement priceT;

    @FindBy(xpath = "(//div[@class='me'])[2]")
    WebElement currencyDropdown;

    @FindBy(className = "ico")
    private List<WebElement> icoElements;

    public FilterBarRealEstate chooseRegion(Region... regions) {
        ArrayList<Region> r = new ArrayList<>();
        clickOnElement(regionDropdown);
        for (WebElement e : regionList) {
            String elementText = e.getText();
            Region regionFromElement = Region.getElementByValue(elementText);
            for (Region region : regions) {
                if (region.equals(regionFromElement)) {
                    clickOnElement(e);
                    r.add(region);
                    if (r.size() == regions.length) {
                        return new FilterBarRealEstate();
                    }
                }
            }
        }
        System.out.println("Region not found in the list.");
        return null;
    }

    public FilterBarRealEstate clickOnChooseButton() {
        clickOnElement(chooseButton);
        System.out.println(" ");
        return this;
    }

    public FilterBarRealEstate choosePriceRange(int priceFrom, int priceTo) {
        try {
            Thread.sleep(2000);
            fillInput(priceF, String.valueOf(priceFrom));
            fillInput(priceT, String.valueOf(priceTo));
            return this;
        } catch (Exception e) {
        }

        return null;
    }

    public FilterBarRealEstate openCurrencyDropdown() {
        clickOnElement(currencyDropdown);
        return this;
    }

    public FilterBarRealEstate chooseCurrency(String currency) {
        for (WebElement element : icoElements) {
            waitForElementVisibility(element);
            if (element.getText().contains(currency)) {
                clickOnElement(element);
                return this;
            }
        }
        return null;
    }


}
