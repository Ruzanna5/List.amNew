package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    @FindBy(xpath = "//label[@class='menu-button-container']")
    WebElement burgerMenu;
    @FindBy(id = "ma")
    WebElement myAccount;

    public Header hoverOnBurgerMenu() {
        hover(burgerMenu);
        return this;
    }
    public LoginPage clickOnMyAccountLink(){
        clickOnElement(myAccount);
        return new LoginPage();
    }

}
