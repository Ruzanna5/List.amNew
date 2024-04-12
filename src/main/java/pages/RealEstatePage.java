package pages;

import enums.Region;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class RealEstatePage extends BasePage {

    @FindBy(xpath = "//div[@id = 'pt']")
    WebElement realEstatePageTitlep;

    @FindBy(xpath = "//*[@id='tp']/div[2]/a")
    List<WebElement> topPosts;


    public String getRealEstatePageTitle() {
        return realEstatePageTitlep.getText();
    }


    public void checkFilterResult(){
        try {
            Thread.sleep(2000);
            for (WebElement post : topPosts.subList(0, 5)) {
                System.out.println(post.getText());
                System.out.println("----------------");
            }
        }catch (Exception e ){}
    }
}