package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // First product from search results
    By firstProduct =
    		By.xpath("//img[@alt='Samsung Galaxy M07 Mobile (Black, 4GB RAM, 64GB Storage) | MediaTek Helio G99 | AnTuTu 624K | IP54| 50MP Camera | 7.6mm Sl...']");

    // Product title
    By productTitle = By.id("productTitle");
    
    public void openFirstProduct() {

        String parentWindow = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();

        // Switch to newly opened tab
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window) ;
                break;
            }
        }
    }

    public String getProductTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle))
                   .getText();
    }
    
    
}