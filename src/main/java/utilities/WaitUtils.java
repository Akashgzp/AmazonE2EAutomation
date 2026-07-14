package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitForClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void waitForTitle(String title) {

        wait.until(ExpectedConditions.titleContains(title));

    }

    public void waitForUrl(String url) {

        wait.until(ExpectedConditions.urlContains(url));

    }

}