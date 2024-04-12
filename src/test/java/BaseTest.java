import Filters.FilterBarRealEstate;
import Filters.FilterBarVehicles;
import pages.RealEstatePage;
import drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.*;

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

    public BaseTest() {
    }

    @BeforeMethod
        public void inits(){
            header = new Header();
            welcomePopup = new WelcomePopup();
            homePage = new HomePage();
            realEstatePage = new RealEstatePage();
            filterBar = new FilterBarRealEstate();
            vehiclesPage = new VehiclesPage();
            filterBarVehicles = new FilterBarVehicles();
            busesPage = new BusesPage();
            vehiclesResultPage =new VehiclesResultPage();
        }

        @AfterSuite(alwaysRun = true)
        public void closeBrowser() {
            driver.quit();
        }

    }
