package automation.listener;

import automation.base.BaseTest;
import automation.utils.ExtentManager;
import automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private ExtentReports extent = ExtentManager.getInstance();
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest baseTest = (BaseTest) result.getInstance();
        WebDriver driver = baseTest.getDriver();

        String testName = result.getName();

        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, testName);

        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}
