package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritePostsPage extends VehiclesPage {

    @FindBy(xpath = "//div[@class = 'dl a']//a/div/div")
    WebElement favPost;

    @FindBy(xpath = "//div[@class='dl a']/a")
    WebElement lastFavPost;
    @FindBy(xpath = "//div[@class = 'footer']/span[1]")
    WebElement postNumber1;

    String postNumber;

    public void chooseLastFavPost(){
        clickOnElement(lastFavPost);
    }

    public String getPostNumber(){
        postNumber = postNumber1.getText();
        System.out.println(postNumber);
        return postNumber;
    }

}
