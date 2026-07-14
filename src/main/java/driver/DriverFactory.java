package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver() {

        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {

            case "chrome":

                tlDriver.set(new ChromeDriver());

                break;

            case "firefox":

                tlDriver.set(new FirefoxDriver());

                break;

            case "edge":

                tlDriver.set(new EdgeDriver());

                break;

            default:

                throw new RuntimeException(
                        "Browser Not Supported : "
                                + browser);

        }

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        return getDriver();

    }

    public static WebDriver getDriver() {

        return tlDriver.get();
    }

    public static void quitDriver() {

        if (getDriver() != null) {

            getDriver().quit();

            tlDriver.remove();

        }
    }

}