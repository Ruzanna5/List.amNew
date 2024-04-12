package drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {


    private static WebDriver driver;

    public static WebDriver createDriver(String browserName){
        switch (browserName){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
