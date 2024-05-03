package pages;

import Filters.FilterBarRealEstate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//a[contains(text(),'Անշարժ գույք')])[1]")
    WebElement realEstate;
    @FindBy(xpath = "(//a[contains(text(),'Տրանսպորտ')])[1]")
    WebElement transport;
    public FilterBarRealEstate clickOnRealeEstateButton(){
        clickOnElement(realEstate);
        return new FilterBarRealEstate();
    }

    public VehiclesPage clickOnVehiclesButton(){
        clickOnElement(transport);
        return new VehiclesPage();
    }


}
