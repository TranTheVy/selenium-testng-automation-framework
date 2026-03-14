package automation.pages;

import automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtils wait;
    public BasePage(WebDriver driver) {
        wait = new WaitUtils(driver);
        this.driver = driver;
    }

    protected void click(By locator) {
        wait.waitForElementClickable(locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        wait.waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        wait.waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }

    protected WebElement find(By locator) {

        return driver.findElement(locator);
    }
}
