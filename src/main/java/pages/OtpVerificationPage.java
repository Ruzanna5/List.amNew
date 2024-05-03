package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtpVerificationPage extends BasePage{

    @FindBy(xpath = "//input[@id = '_idcode']")
    WebElement otpInput;

    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement submitButton;

    public OtpVerificationPage fillOtpInput(String value) {
        fillInput(otpInput, value);
        return this;
    }
    public RegistrationPage clickOnSubmitButton(){
        clickOnElement(submitButton);
        return new RegistrationPage();
    }

}
