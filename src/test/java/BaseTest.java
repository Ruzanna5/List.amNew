import Filters.FilterBarRealEstate;
import Filters.FilterBarVehicles;
import pages.RealEstatePage;
import drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver = DriverManager.createDriver("chrome");
    protected Header header;
    protected WelcomePopup welcomePopup;
    protected HomePage homePage;
    protected RealEstatePage realEstatePage;
    protected FilterBarRealEstate filterBar;
    protected FilterBarVehicles filterBarVehicles;
    protected VehiclesPage vehiclesPage;
    protected VehiclesResultPage vehiclesResultPage;
    protected BusesPage busesPage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected OtpVerificationPage verificationPage;
    protected Mailinator mailinator;
    protected  MyPostsPage myPostsPage;
    protected FavoritePostsPage favoritePostsPage;

    public BaseTest() {
    }

    @BeforeMethod
    public void inits() throws IOException {
        header = new Header();
        welcomePopup = new WelcomePopup();
        homePage = new HomePage();
        realEstatePage = new RealEstatePage();
        filterBar = new FilterBarRealEstate();
        vehiclesPage = new VehiclesPage();
        filterBarVehicles = new FilterBarVehicles();
        busesPage = new BusesPage();
        vehiclesResultPage = new VehiclesResultPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        verificationPage = new OtpVerificationPage();
        mailinator = new Mailinator();
        myPostsPage = new MyPostsPage();
        favoritePostsPage = new FavoritePostsPage();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
