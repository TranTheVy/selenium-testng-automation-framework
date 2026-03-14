package automation.base;

import automation.factory.DriverFactory;
import automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest {
    protected  WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));


    }

    @AfterMethod
    public void teardown() {

        DriverFactory.quitDriver();

    }

    public  WebDriver getDriver() {
        return driver;
    }
}
