package pages;

import constants.PageTitles;
import constants.Urls;
import enums.RegistrMetod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//div[@class='irt']//label")
    List<WebElement> registrMetodList;
    @FindBy(id = "_idyour_email")
    WebElement emailInputField;
    @FindBy(id = "action__form_action0")
    WebElement nextButton;
    @FindBy(id = "_idfirst_and_last_name")
    WebElement firstLastNameInputField;
    @FindBy(id = "_idcreate____password")
    WebElement passwordInputField;
    @FindBy(id = "action__form_action0")
    WebElement registrationButton;

    public String email;

    public RegistrationPage chooseRegistrMetod(RegistrMetod registrMetod) {
        for (WebElement e : registrMetodList) {
            if (registrMetod.getValue().equals(e.getText())) {
                clickOnElement(e);
            }
        }
        return this;
    }

    public int randomInt() {
        Random randomEmail = new Random();
        int randomInt = randomEmail.nextInt(10000);
        return randomInt;
    }
    public RegistrationPage fillEmailInputField(String name) {
        String newEmail = name + randomInt() + "@mailinator.com";
        this.email = newEmail;
        fillInput(emailInputField, newEmail);
        clickOnNextButton();
        return new RegistrationPage();
    }

    public RegistrationPage clickOnNextButton() {
        try {
            Thread.sleep(7000);
            clickOnElement(nextButton);
        } catch (Exception e) {
        }
        return this;
    }

    public Mailinator openMailinatorInbox() {
        driver.switchTo().newWindow(WindowType.TAB);
        openPage(Urls.MAILINATOR + email);
        return new Mailinator();
    }

    public RegistrationPage fillFirstLastNameInputField(String  firtsName,String lastName) {
        fillInput(firstLastNameInputField, firtsName, lastName);
        return this;
    }

    public RegistrationPage fillPasswordInputField(String password) {
        fillInput(passwordInputField, password);
        return this;
    }

    public MyPostsPage clickOnRegistration() {
        clickOnElement(registrationButton);
        return new MyPostsPage();
    }


}
