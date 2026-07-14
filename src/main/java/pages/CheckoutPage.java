package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // Proceed To Checkout Button
    By proceedToCheckout = By.name("proceedToRetailCheckout");

    // Address Heading
    By addressHeading = By.xpath("//h1[contains(text(),'Select a delivery address')]");

    public void clickProceedToCheckout() {

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();

    }

    public boolean isAddressPageDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(addressHeading)).isDisplayed();

    }

}