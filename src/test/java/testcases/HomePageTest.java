package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {

//	@Test
//	public void verifyHomePage() {
//		
//		 // Step 1 : Home Page
//        HomePage home = new HomePage(driver);
//        home.clickSignIn();
//        System.out.println("Poll SCM Test");
//	}

	@Test(priority = 1)
	public void verifyHomePageURL() {

		HomePage home = new HomePage(driver);

		Assert.assertEquals(home.getCurrentURL(), "https://www.amazon.in/");
	}

	@Test(priority = 2)
	public void verifyPageTitle() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.titleContains("Amazon"));

	    Assert.assertTrue(driver.getTitle().contains("Amazon"));
	}
	
	@Test(priority = 3)
	public void verifyAmazonLogo() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isLogoDisplayed());
	}

	@Test(priority = 4)
	public void verifySearchBox() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isSearchBoxDisplayed());
	}

	@Test(priority = 5)
	public void verifySearchButton() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isSearchButtonDisplayed());
	}

	@Test(priority = 6)
	public void verifyCartIcon() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isCartDisplayed());
	}

	@Test(priority = 7)
	public void verifySignInLink() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isSignInDisplayed());
	}

	@Test(priority = 8)
	public void verifyReturnsOrdersLink() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isReturnsOrdersDisplayed());
	}

	@Test(priority = 9)
	public void verifyHamburgerMenu() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isHamburgerDisplayed());
	}

	@Test(priority = 10)
	public void verifyLanguageSelector() {

		HomePage home = new HomePage(driver);

		Assert.assertTrue(home.isLanguageDisplayed());
	}
	
	// ===============================
		// Sprint 2 - Search Tester
		// TC011 - TC020
		// ===============================
	
	@Test(priority = 11)
	public void verifySearchBoxAcceptsText() {

	    HomePage home = new HomePage(driver);

	    home.enterSearchText("Samsung");

	    Assert.assertEquals(home.getSearchBoxValue(), "Samsung");

	}
	
	@Test(priority = 12)
	public void verifySearchWithValidProduct() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("Samsung");

	    Assert.assertTrue(home.getCurrentURL().contains("s?k=Samsung"));

	}
	
	@Test(priority = 13)
	public void verifySearchWithInvalidProduct() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("XYZ123INVALIDPRODUCT");

	    Assert.assertTrue(home.getCurrentURL()
	            .contains("XYZ123INVALIDPRODUCT"));

	}
	
	@Test(priority = 14)
	public void verifySearchWithEmptyText() {

	    HomePage home = new HomePage(driver);

	    home.enterSearchText("");

	    home.clickSearchButton();

	    Assert.assertTrue(home.getCurrentURL().contains("amazon"));

	}
	
	@Test(priority = 15)
	public void verifySearchWithSpaces() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("     ");

	    Assert.assertTrue(home.getCurrentURL().contains("amazon"));

	}
	
	@Test(priority = 16)
	public void verifySearchWithNumbers() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("123456");

	    Assert.assertTrue(home.getCurrentURL().contains("123456"));

	}
	
	@Test(priority = 17)
	public void verifySearchWithSpecialCharacters() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("@#$%");

	    Assert.assertTrue(home.getCurrentURL().contains("amazon"));

	}
	
	@Test(priority=18)
	public void verifySearchResultTitle() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("Laptop");

	    Assert.assertTrue(
	            home.getPageTitle()
	                    .contains("Laptop"));

	}
	
	@Test(priority=19)
	public void verifySearchResultURL() {

	    HomePage home = new HomePage(driver);

	    home.searchProduct("Laptop");

	    Assert.assertTrue(
	            home.getCurrentURL()
	                    .contains("s"));
	}
	
	@Test(priority=20)
	public void verifySearchBoxClear() {

	    HomePage home = new HomePage(driver);

	    home.enterSearchText("Samsung");

	    home.clearSearchBox();

	    Assert.assertEquals(
	            home.getSearchBoxValue(),
	            "");

	}
	
	
	// ===============================
	// Sprint 2 - Search Tester
	// TC021 - TC030
    // ===============================
	
	@Test(priority = 21)
	public void verifyLogoClick() {

	    HomePage home = new HomePage(driver);

	    home.clickLogo();

	    Assert.assertTrue(driver.getCurrentUrl().contains("amazon.in"));
	}
	
	@Test(priority = 22)
	public void verifyCartClick() {
		
		HomePage home = new HomePage(driver);
		
		home.clickCart();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/cart"));
	}
	
	@Test(priority = 23)
	public void verifySignInClick() {
		
		HomePage home = new HomePage(driver);
		
		home.clickSignIn();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("signin"));
	}

	@Test(priority = 24)
	public void verifyReturnsOrdersClick() {
		
		HomePage home = new HomePage(driver);
		
		home.clickReturnsOrders();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("signin"));
	}
	
	@Test(priority = 25)
	public void verifyHamburgerMenuClick() {

	    HomePage home = new HomePage(driver);

	    home.clickHamburgerMenu();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hmenu-content")));

	    Assert.assertTrue(menu.isDisplayed());
	}
	
	@Test(priority = 26)
	public void verifyLanguageSelectorClick() {

	    HomePage home = new HomePage(driver);

	    home.clickLanguageSelector();

	    Assert.assertTrue(driver.getPageSource().contains("English"));
	}
	
	@Test(priority = 27)
	public void verifyDeliveryLocationClick() {

	    HomePage home = new HomePage(driver);

	    home.clickDeliveryLocation();

	    Assert.assertTrue(driver.getPageSource().contains("Choose your location"));
	}
	
	@Test(priority = 28)
	public void verifyTodaysDealsClick() {

	    HomePage home = new HomePage(driver);

	    home.clickTodaysDeals();

	    Assert.assertTrue(driver.getCurrentUrl().contains("/deals"));
	}
	
	@Test(priority = 29)
	public void verifyCustomerServiceClick() {

	    HomePage home = new HomePage(driver);

	    home.clickCustomerService();

	    Assert.assertTrue(driver.getTitle().contains("Customer Service"));
	}
	
	@Test(priority = 30)
	public void verifyGiftCardsClick() {

	    HomePage home = new HomePage(driver);

	    home.clickGiftCards();

	    Assert.assertTrue(driver.getTitle().contains("Gift Cards"));
	}
	
	// ===============================
		// Sprint 2 - footer Tester
		// TC021 - TC030
	    // ===============================
	
	@Test(priority = 31)
	public void verifyFooterDisplayed() {

	    HomePage home = new HomePage(driver);

	    Assert.assertTrue(home.isFooterDisplayed());

	}
	
	@Test(priority = 32)
	public void verifyBackToTop() {

	    HomePage home = new HomePage(driver);

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	    home.clickBackToTop();

	    Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

	}
	
	@Test(priority = 33)
	public void verifyAboutAmazonLink() {

	    HomePage home = new HomePage(driver);

	    home.clickAboutAmazon();

	    Assert.assertTrue(driver.getTitle().contains("About"));

	}
	
	@Test(priority = 34)
	public void verifyCareersLink() {
		
		HomePage home = new HomePage(driver);
		
		home.clickCareers();
//		System.out.println("Title: " +  driver.getTitle());
//		System.out.println("Url: " +  driver.getCurrentUrl());
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://amazon.jobs/en/"));
	}
	
	@Test(priority = 35)
	public void verifyPressReleasesLink() {

	    HomePage home = new HomePage(driver);

	    home.clickPressReleases();

	    Assert.assertTrue(driver.getTitle().contains("Press"));

	}
	
	
	@Test(priority = 36)
	public void verifyAccessiblilityLink() {
		
		HomePage home = new HomePage(driver);
		
		home.clickAccessibility();
		
//		Assert.assertTrue(driver.getTitle().contains("accessibility"));
	}
}
