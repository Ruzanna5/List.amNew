import Filters.FilterBarVehicles;
import constants.Languages;
import constants.PageTitles;
import enums.Region;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.VehiclesResultPage;


import static constants.PageTitles.REAL_ESTATE;
import static constants.Urls.LIST_AM;
import static enums.Engines.DISEL;
import static enums.Region.*;


public class tests extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void firstTest() {
        header.openPage(LIST_AM);
        welcomePopup.chooseLanguage(Languages.AM);
        homePage
                .clickOnRealeEstateButton()
                .getRealEstatePageTitle();
        softAssert.assertEquals(realEstatePage.getRealEstatePageTitle(), REAL_ESTATE);
        filterBar
                .chooseRegion(AJAPNYAK,ARABKIR)
                .clickOnChooseButton()
                .choosePriceRange(1000, 50000)
                .openCurrencyDropdown()
                .chooseCurrency("AMD")
                .checkFilterResult();
        softAssert.assertAll();

    }

    @Test
    public void secondTest() {
        homePage.openPage(LIST_AM);
        welcomePopup.chooseLanguage(Languages.AM);
        homePage
                .clickOnVehiclesButton()
                .chooseBusFromList();
        softAssert.assertEquals(busesPage.getBusesPageTitle(), PageTitles.BUSES);
        softAssert.assertEquals(vehiclesPage.getTransportPageTitle(), PageTitles.TRANSPORT);
       filterBarVehicles
                .openEngineDropdown()
                .chooseEngineType(DISEL)
                .openPost(2)
                .checkResult();
        softAssert.assertAll();


    }
}
