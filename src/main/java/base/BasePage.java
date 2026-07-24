package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public void type(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();

        element.sendKeys(value);
    }

    public String getText(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    public void waitFor(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Scroll to element
    public void scrollToElement(WebElement element) {

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // JS Click
    public void clickByJS(WebElement element) {

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].click();", element);
    }

    // Current Page Title
    public String getPageTitle() {

        return driver.getTitle();
    }

    // Current URL
    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }
    
    // Wait for Clickable Locator
    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }
    
    // Wait for Visible Locator
    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    // Wait for Title
    public void waitForTitleContains(String title) {

        wait.until(
                ExpectedConditions.titleContains(title));
    }
    
    // Wait for URL
    public void waitForURLContains(String url) {

        wait.until(
                ExpectedConditions.urlContains(url));
    }
    
    // Wait for Invisibility (Useful for Loaders)
    public void waitForInvisibility(By locator) {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    // Wait for Alert
    public void waitForAlert() {

        wait.until(
                ExpectedConditions.alertIsPresent());
    }

}