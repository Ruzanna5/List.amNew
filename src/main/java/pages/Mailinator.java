package pages;

import drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Mailinator extends BasePage {
    @FindBy(xpath = "//table[@class ='table-striped jambo_table']//tr")
    List<WebElement> messageList;

    @FindBy(xpath = "//div[@class='main']/div")
    WebElement otp;
    @FindBy(id = "html_msg_body")
    WebElement iFrame;

    public String getOtpValue() {
        return otpValue;
    }

    private String otpValue;

    public void chooseLatestMessage() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@class ='table-striped jambo_table']//tr"), 0));
        messageList.get(0).click();
    }

    public OtpVerificationPage getOtp() {
        switchToIframe(iFrame);
        waitForElementVisibility(otp);
        otpValue = otp.getText();
        switchToTab(0);
        return new OtpVerificationPage();
    }


}
