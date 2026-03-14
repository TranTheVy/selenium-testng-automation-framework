package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By successMsg = By.id("flash");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String user){
        type(username,user);
    }

    public void enterPassword(String pass){
        type(password, pass);
    }

    public void clickLogin(){
        click(loginBtn);
    }

    public String getSuccessMessage() {

        return getText(successMsg);
    }
}
