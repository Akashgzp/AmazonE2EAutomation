package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    By addToCart = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
    
//  Product add to cart.
    public void clickAddToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

    }


}