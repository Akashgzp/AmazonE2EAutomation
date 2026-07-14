package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import driver.DriverFactory;

public class ScreenshotUtils {

    public static String captureScreenshot(String fileName) {

        WebDriver driver = DriverFactory.getDriver();

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String destination =
                "Screenshots/" + fileName + ".png";

        try {

            FileUtils.copyFile(src, new File(destination));

        } catch (IOException e) {

            e.printStackTrace();

        }

        return destination;

    }

}