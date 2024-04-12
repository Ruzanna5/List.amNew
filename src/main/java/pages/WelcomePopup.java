package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePopup extends BasePage {

    @FindBy(xpath = "//div[@class='bar']//a")
    List<WebElement> languages;
    @FindBy(xpath = "//*[@id=\"dlgLangSel\"]/div[3]/a[3]")
    WebElement languages1;


//public WelcomePopup chooseLanguage(String lang){
//    if (languages1.getText().equals(lang)){
//        clickOnElement(languages1);
//        System.out.println();
//        return this;
//    }
//    return null;


    public HomePage chooseLanguage(String language) {
        for (WebElement lang : languages) {
            waitForElementVisibility(lang);
            if (lang.getText().equals(language)){
                lang.click();
                return new HomePage();
            }
        }return null;
    }

}
