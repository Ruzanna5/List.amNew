package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPostsPage extends Header{
    @FindBy(xpath = "//div[@id= 'ph']//a[@id = 'l']")
    WebElement homePage;


    public HomePage clickOnHomePageButton(){
        clickOnElement(homePage);
        return new HomePage();
    }
}
