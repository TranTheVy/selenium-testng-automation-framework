package automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    public static String takeScreenshot(WebDriver driver, String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = "test-output/screenshots/" + testName + ".png";

        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
