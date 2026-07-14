package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    WebDriver driver;
    WebDriverWait wait;

    public AddressPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // Locators
    
    By clickaddressbtn = By.xpath("//a[normalize-space()='Add a new delivery address']");
    
    By fullName = By.id("address-ui-widgets-enterAddressFullName");

    By mobile = By.id("address-ui-widgets-enterAddressPhoneNumber");

    By pinCode = By.id("address-ui-widgets-enterAddressPostalCode");

    By flat = By.id("address-ui-widgets-enterAddressLine1");

    By area = By.id("address-ui-widgets-enterAddressLine2");

    By landmark = By.id("address-ui-widgets-landmark");

    By city = By.id("address-ui-widgets-enterAddressCity");
    
    By stateDropDown = By.xpath("//span[contains(text(),'Choose a state')]");

    By uttarPradesh =
    By.xpath("//a[contains(text(),'UTTAR PRADESH')]");

    By useThisAddress = By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']");

    // Actions

    public void enterAddress1() {

        wait.until(ExpectedConditions.elementToBeClickable(clickaddressbtn)).click();

    }
    public void enterAddress(
            String name,
            String phone,
            String pin,
            String flatNo,
            String areaName,
            String landmarkName,
            String cityName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName))
                .sendKeys(name);

        driver.findElement(mobile).sendKeys(phone);

        driver.findElement(pinCode).sendKeys(pin);

        driver.findElement(flat).sendKeys(flatNo);

        driver.findElement(area).sendKeys(areaName);

        driver.findElement(landmark).sendKeys(landmarkName);

        driver.findElement(city).sendKeys(cityName);

    }

    public void selectState() {

        wait.until(ExpectedConditions.elementToBeClickable(stateDropDown)).click();

        wait.until(ExpectedConditions.elementToBeClickable(uttarPradesh)).click();

    }
    
    public void clickUseThisAddress() {

        wait.until(ExpectedConditions.elementToBeClickable(useThisAddress)).click();

    }
    
    public boolean isAddressPresent() {

        return driver.getPageSource().contains("Delivering to");

    }
    
  
}
