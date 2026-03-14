package automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        switch (browser.toLowerCase()) {

            case "chrome":
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        getDriver().quit();

        driver.remove();
    }
}
