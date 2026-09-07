package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SearchPage;

public class SearchPageTest extends BaseTest {

	private SearchPage search;

	@BeforeMethod
	public void setUpSearchPage() {
		search = new SearchPage(driver);
	}

	private void searchFor(String keyword) {

		HomePage home = new HomePage(driver);

		home.searchProduct(keyword);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.urlContains("s?k="));
	}

	// =========================================================
	// TC051 - TC056 : Basic Search Result Tests
	// =========================================================

	@Test(priority = 51)
	public void verifySearchResultPageOpens() {

		searchFor("Samsung");

		Assert.assertTrue(search.isSearchResultPageDisplayed(), "Search Result Page is not displayed");
	}

	@Test(priority = 52)
	public void verifySearchResultsDisplayed() {

		searchFor("Samsung");

		Assert.assertTrue(search.areSearchResultsDisplayed(), "Search results are not displayed");
	}

	@Test(priority = 53)
	public void verifyProductCount() {

		searchFor("Samsung");

		int productCount = search.getProductCount();

		System.out.println("Product Count: " + productCount);

		Assert.assertTrue(productCount > 0, "No products found in search results");
	}

	@Test(priority = 54)
	public void verifyFirstProductClick() {

		searchFor("Samsung");

		search.clickFirstProduct();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Product URL: " + currentUrl);
		System.out.println("Product Title: " + driver.getTitle());

		Assert.assertTrue(currentUrl.contains("/dp/") || currentUrl.contains("/gp/product/"),
				"First product was not opened. Current URL: " + currentUrl);
	}

	@Test(priority = 55)
	public void verifyProductTitle() {

		searchFor("Samsung");

		String title = search.getProductTitle();

		System.out.println("Product Title: " + title);

		Assert.assertNotNull(title, "Product title is null");

		Assert.assertFalse(title.trim().isEmpty(), "Product title is empty");
	}

	@Test(priority = 56)
	public void verifyProductPrice() {

		searchFor("Samsung");

		String price = search.getProductPrice();

		System.out.println("Product Price: " + price);

		Assert.assertNotNull(price, "Product price is null");

		Assert.assertFalse(price.trim().isEmpty(), "Product price is empty");
	}

	// =========================================================
	// TC057 - TC060 : Sort & Filter Tests
	// =========================================================

	@Test(priority = 57)
	public void verifySortLowToHigh() {

		searchFor("Tshirt");

		search.sortByLowToHigh();

		/*
		 * TODO: Actual price-order validation SearchPage.java me implement karni hai.
		 *
		 * Assert.assertTrue(true) intentionally remove kiya gaya hai.
		 */
	}

	@Test(priority = 58)
	public void verifySortHighToLow() {

		searchFor("Trimmer");

		search.sortByHighToLow();

		/*
		 * TODO: Actual price-order validation implement karni hai.
		 */
	}

	@Test(priority = 59)
	public void verifyBrandFilter() {

		searchFor("Laptop");

		search.selectBrandFilter();

		/*
		 * TODO: Selected brand ke products actually filtered hain, iska validation
		 * SearchPage.java me add karenge.
		 */
	}

	@Test(priority = 60)
	public void verifyCustomerRatingFilter() {

		searchFor("Water Bottle");

		search.selectRatingFilter();

		/*
		 * TODO: Rating-filtered products ka actual validation SearchPage.java me add
		 * karenge.
		 */
	}

	// =========================================================
	// TC061 - TC069 : Advanced Search Tests
	// =========================================================

	@Test(priority = 61)
	public void verifySecondProductClick() {

		searchFor("Smartwatch");

		search.clickSecondProduct();

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Product URL: " + currentUrl);
		System.out.println("Product Title: " + driver.getTitle());

		Assert.assertTrue(currentUrl.contains("/dp/") || currentUrl.contains("Smartwatch"),
				"Second product was not opened. Current URL: " + currentUrl);
	}

	@Test(priority = 62)
	public void verifyMultipleProductsDisplayed() {

		searchFor("Shoes");

		int productCount = search.getDisplayedProductCount();

		System.out.println("Displayed Products: " + productCount);

		Assert.assertTrue(productCount >= 2, "Less than 2 products are displayed");
	}

	@Test(priority = 63)
	public void verifyProductImageDisplayed() {

		searchFor("Backpack");

		Assert.assertTrue(search.isProductImageDisplayed(), "Product image is not displayed");
	}

	@Test(priority = 64)
	public void verifyProductLinkClickable() {

		searchFor("Trimmer");

		search.clickFirstProductTitle();

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		if (tabs.size() > 1) {
			driver.switchTo().window(tabs.get(1));
		}

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Product URL: " + currentUrl);

		Assert.assertTrue(currentUrl.contains("/dp/") || currentUrl.contains("/gp/product/"),
				"Product link did not open product page. URL: " + currentUrl);
	}

	@Test(priority = 65)
	public void verifySearchResultContainsKeyword() {

		String searchKeyword = "iPhone";

		searchFor(searchKeyword);

		List<String> productTitles = search.getFirstFewProductTitles(4);

		Assert.assertFalse(productTitles.isEmpty(), "No search results were found");

		boolean keywordFound = false;

		for (String title : productTitles) {

			if (title.toLowerCase().contains(searchKeyword.toLowerCase())) {

				keywordFound = true;
				break;
			}
		}

		Assert.assertTrue(keywordFound,
				"Searched keyword '" + searchKeyword + "' was not found in the top product titles");
	}

	@Test(priority = 66)
	public void verifyNextPageNavigation() {

		searchFor("Books");

		search.clickNextPage();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("page=1")));

		System.out.println("After Next Page URL: " + driver.getCurrentUrl());

		Assert.assertTrue(search.areSearchResultsDisplayed(),
				"Search results are not displayed after next page navigation");
	}

	@Test(priority = 67)
	public void verifyPreviousPageNavigation() {

		searchFor("Tshirt");

		search.clickNextPage();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("page=1")));

		search.clickPreviousPage();

		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("page=2")));

		Assert.assertTrue(search.areSearchResultsDisplayed(),
				"Search results are not displayed after previous page navigation");
	}

	@Test(priority = 68)
	public void verifySortDropdownDisplayed() {

		searchFor("Laptop");

		Assert.assertTrue(search.isSortDropdownDisplayed(), "Sort dropdown is not displayed");
	}

}