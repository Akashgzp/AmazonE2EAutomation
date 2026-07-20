package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {

        super(driver);
    }

//    @FindBy(id="nav-link-accountList")
//    WebElement signIn;
//
//    public void clickSignIn() {
//
//        click(signIn);

//    }
	
 // ==========================
    // Locators
    // ==========================

    private By logo = By.id("nav-logo-sprites");

    private By searchBox = By.id("twotabsearchtextbox");

    private By searchButton = By.id("nav-search-submit-button");

    private By cartIcon = By.id("nav-cart");

    private By signIn = By.id("nav-link-accountList");

    private By returnsOrders = By.id("nav-orders");

    private By hamburgerMenu = By.id("nav-hamburger-menu");

    private By language = By.id("icp-nav-flyout");

 // URL
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    // Title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Logo
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    // Search Box
    public boolean isSearchBoxDisplayed() {
        return driver.findElement(searchBox).isDisplayed();
    }

    // Search Button
    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchButton).isDisplayed();
    }

    // Cart
    public boolean isCartDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    // Sign In
    public boolean isSignInDisplayed() {
        return driver.findElement(signIn).isDisplayed();
    }

    // Returns & Orders
    public boolean isReturnsOrdersDisplayed() {
        return driver.findElement(returnsOrders).isDisplayed();
    }

    // Hamburger
    public boolean isHamburgerDisplayed() {
        return driver.findElement(hamburgerMenu).isDisplayed();
    }

    // Language
    public boolean isLanguageDisplayed() {
        return driver.findElement(language).isDisplayed();
    }
    
 // ===============================
 // Sprint 2 - Search Locators
 // TC011 - TC020
 // ===============================

 // Search Text Box
 private By searchBox1 = By.id("twotabsearchtextbox");

 // Search Button
 private By searchButton1 = By.id("nav-search-submit-button");


 // Clear Search Box (same searchBox locator is used)
 
 // Method of searchbox.
 
//Enter Search Text
public void enterSearchText(String product) {

  driver.findElement(searchBox).clear();
  driver.findElement(searchBox).sendKeys(product);

}

//Click Search Button
public void clickSearchButton() {

  driver.findElement(searchButton).click();

}

//Search Product
public void searchProduct(String product) {

  enterSearchText(product);

  clickSearchButton();

}

//Get Search Box Value
public String getSearchBoxValue() {

  return driver.findElement(searchBox)
          .getAttribute("value");

}

//Clear Search Box
public void clearSearchBox() {

  driver.findElement(searchBox).clear();

}

//Search Box Enabled
public boolean isSearchBoxEnabled() {

  return driver.findElement(searchBox).isEnabled();

}

//Search Button Enabled
public boolean isSearchButtonEnabled() {

  return driver.findElement(searchButton).isEnabled();

}

//Current URL
public String getCurrentURL1() {

  return driver.getCurrentUrl();

}

//Page Title
public String getPageTitle1() {

  return driver.getTitle();

}
}