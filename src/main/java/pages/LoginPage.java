package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginPage extends Header {
    @FindBy(xpath = "//a[@href= '/register']")
    WebElement registrButton;

    public RegistrationPage clickOnRegistrationButton() {
        clickOnElement(registrButton);
        return new RegistrationPage();
    }

}
