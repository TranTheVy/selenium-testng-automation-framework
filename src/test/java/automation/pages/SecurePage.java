package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage {
    private By message = By.id("flash");

    public SecurePage(WebDriver driver){
        super(driver);
    }

    public String getMessage(){
        return getText(message);
    }
}
