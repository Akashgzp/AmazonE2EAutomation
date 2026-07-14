package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // Locators

    By creditCard = By.xpath("//span[contains(text(),'Credit or debit card')]");

    By netBanking = By.xpath("//span[contains(text(),'Net Banking')]");

    By emi = By.xpath("//span[contains(text(),'EMI')]");

    By paymentButton = By.xpath("//input[contains(@aria-labelledby,'continue-top')]");

    // Verify Payment Page

    public boolean verifyPaymentPage() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCard))
                .isDisplayed();

    }

    // Select Credit Card

    public void selectCreditCard() {

        wait.until(ExpectedConditions.elementToBeClickable(creditCard)).click();

    }

    // Continue

    public void clickUseThisPaymentMethod() {

        wait.until(ExpectedConditions.elementToBeClickable(paymentButton)).click();

    }

}