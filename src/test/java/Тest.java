import constants.PageTitles;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VehiclesPage;


import static constants.Languages.AM;
import static constants.PageTitles.REAL_ESTATE;
import static constants.Urls.LIST_AM;
import static enums.Currency.AMD;
import static enums.Engines.DISEL;
import static enums.Region.*;
import static enums.RegistrMetod.EMAIL;


public class Тest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void firstTest() {
        header.openPage(LIST_AM);
        welcomePopup.chooseLanguage(AM);
        homePage
                .clickOnRealeEstateButton()
                .getRealEstatePageTitle();
        softAssert.assertEquals(realEstatePage.getRealEstatePageTitle(), REAL_ESTATE);
        filterBar
                .chooseRegion(AJAPNYAK, ARABKIR, APAGA)
                .clickOnChooseButton()
                .choosePriceRange(1000, 50000)
                .openCurrencyDropdown()
                .chooseCurrency(AMD)
                .checkFilterResult(0, 5);
        softAssert.assertAll();

    }

    @Test
    public void secondTest() {
        homePage.openPage(LIST_AM);
        welcomePopup.chooseLanguage(AM);
        homePage
                .clickOnVehiclesButton()
                .chooseBusFromList();
        softAssert.assertEquals(busesPage.getBusesPageTitle(), PageTitles.BUSES);
        softAssert.assertEquals(vehiclesPage.getTransportPageTitle(), PageTitles.TRANSPORT);
        filterBarVehicles
                .openEngineDropdown()
                .chooseEngineType(DISEL)
                .openPost(1)
                .checkResult();
        softAssert.assertAll();
        ///////
        new VehiclesPage().likePost();

    }

    @Test
    public void thirdTest() {
        homePage.openPage(LIST_AM);
        welcomePopup.chooseLanguage(AM);
        loginPage
                .clickOnMyAccountLink()
                .clickOnRegistrationButton()
                .chooseRegistrMetod(EMAIL);
        registrationPage
                .fillEmailInputField("vazgen");
        registrationPage
                .openMailinatorInbox()
                .chooseLatestMessage();
        mailinator.getOtp();
        verificationPage.fillOtpInput(mailinator.getOtpValue())
                .clickOnSubmitButton()
                .fillFirstLastNameInputField("Vazgen", "Khachatryan")
                .fillPasswordInputField("Testing1234")
                .clickOnRegistration();
        myPostsPage.clickOnHomePageButton()
                .clickOnVehiclesButton()
                .chooseOneOfposts()
                .likePost()
                .getLastPostNumber();
        VehiclesPage veh = new VehiclesPage();
                veh.openFavoritePostsPage()
                .chooseLastFavPost();
        favoritePostsPage.getPostNumber();
        VehiclesPage veh1 = new VehiclesPage();
        softAssert.assertEquals(veh1.getLastPostNumber(), favoritePostsPage.getPostNumber());
        softAssert.assertAll();

    }
}

