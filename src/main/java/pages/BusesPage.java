package pages;

import org.openqa.selenium.WebDriver;

public class BusesPage extends BasePage{

    public String getBusesPageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;

    }


}
