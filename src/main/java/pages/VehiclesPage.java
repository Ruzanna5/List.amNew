package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehiclesPage extends BasePage {
    @FindBy(xpath = "//div[@id = 'pt']")
    WebElement transportPageTitle;
    @FindBy(xpath = "//a[contains(text(),'Եվս 18')]")
    WebElement more18;
    @FindBy(xpath = "(//a[contains(text(),'Ավտոբուսներ')])[1]")
    WebElement buses;

    @FindBy(xpath = "//*[@id='tp']/div[2]/a")
    List<WebElement> topPostList;

    @FindBy(xpath = "//div[@id='sstar']/div")
    WebElement likeButtonInItemPage;

    @FindBy(xpath = "//div[@class = 'b']//div[@id = 'ma']")
    WebElement profileDropdown;
    @FindBy(xpath = "//div[@id = 'ma']//div[@class = 'umsads']")
    WebElement favoritePosts;

    @FindBy(xpath = "//div[@class = 'footer']/span[1]")
    WebElement lastLikedPostNumber;

    String lastPostNum;


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

    public VehiclesPage chooseOneOfposts() {
        clickOnElement(topPostList.get(0));
        switchToTab(2);
        return this;
    }

    public VehiclesPage likePost() {
        clickOnElement(likeButtonInItemPage);
        return this;
    }

    public String getLastPostNumber() {
         lastPostNum = lastLikedPostNumber.getText();
         return lastPostNum;
    }

    public void openProfileDropdown() {
        hover(profileDropdown);
    }

    public FavoritePostsPage openFavoritePostsPage(){
        openProfileDropdown();
        clickOnElement(favoritePosts);
        return new FavoritePostsPage();
    }
}
