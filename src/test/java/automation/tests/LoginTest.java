package automation.tests;

import automation.base.BaseTest;
import automation.listener.TestListener;
import automation.pages.LoginPage;
import automation.utils.ExcelUtils;
import automation.utils.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData",retryAnalyzer = RetryAnalyzer.class)
    public void testLogin(String username, String password, String expectedMessage) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualMessage = loginPage.getSuccessMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
    @DataProvider(name="loginData")
    public Object[][] getData() throws Exception {

        return ExcelUtils.getLoginData();
    }

}
