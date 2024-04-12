package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    @FindBy(xpath = "//label[@class='menu-button-container']")
    WebElement burgerMenu;
    public Header hoverOnBurgerMenu() {
        hover(burgerMenu);
        return this;

    }

}
