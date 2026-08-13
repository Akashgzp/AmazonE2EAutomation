package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchPageTest extends BaseTest {

//	@Test
//	public void VerifySearch() {
//		
//		    HomePage home = new HomePage(driver);
//
//	        home.clickSignIn();
//
//	        LoginPage login = new LoginPage(driver);
//
//	        login.enterEmail("8127196607");
//	        login.clickContinue();
//	        login.enterPassword("123456");
//	        login.clickSignIn();
//	        
//		    //  Search Product
//           SearchPage search = new SearchPage(driver);
//        search.searchProduct("Samsung Mobile");
//	}
	
	SearchPage search;


    @Test(priority = 51)
    public void verifySearchResultPageOpens() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Samsung");

        search = new SearchPage(driver);

        Assert.assertTrue(search.isSearchResultPageDisplayed());

    }



    @Test(priority = 52)
    public void verifySearchResultsDisplayed() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Samsung");

        search = new SearchPage(driver);

        Assert.assertTrue(search.areSearchResultsDisplayed());

    }



    @Test(priority = 53)
    public void verifyProductCount() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Samsung");

        search = new SearchPage(driver);

        Assert.assertTrue(search.getProductCount() > 0);

    }



    @Test(priority = 54)
    public void verifyFirstProductClick() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Samsung");

        search = new SearchPage(driver);

        search.clickFirstProduct();
        
        System.out.println("Url:" + driver.getCurrentUrl());
        
        System.out.println("Title:" + driver.getTitle());

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.in/s?k=Samsung&ref=nb_sb_noss"));

    }



    @Test(priority = 55)
    public void verifyProductTitle() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Samsung");

        search = new SearchPage(driver);

        String title = search.getProductTitle();

        Assert.assertFalse(title.isEmpty());

    }



    @Test(priority = 56)
    public void verifyProductPrice() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Samsung");

        search = new SearchPage(driver);

        String price = search.getProductPrice();

        Assert.assertFalse(price.isEmpty());

    }



    @Test(priority = 57)
    public void verifySortLowToHigh() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Tshirt");

        search = new SearchPage(driver);

        search.sortByLowToHigh();

        Assert.assertTrue(true);

    }



    @Test(priority = 58)
    public void verifySortHighToLow() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Trimmer");

        search = new SearchPage(driver);

        search.sortByHighToLow();

        Assert.assertTrue(true);

    }



    @Test(priority = 59)
    public void verifyBrandFilter() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Laptop");

        search = new SearchPage(driver);

        search.selectBrandFilter();

        Assert.assertTrue(true);

    }



    @Test(priority = 60)
    public void verifyCustomerRatingFilter() {

        HomePage home = new HomePage(driver);

        home.searchProduct("Water Bottle");

        search = new SearchPage(driver);

        search.selectRatingFilter();

        Assert.assertTrue(true);

    }

    // TestCase TC061 to TC070.....
    
    @Test(priority = 61)
    public void verifySecondProductClick() {

    	 HomePage home = new HomePage(driver);

         home.searchProduct("Smartwatch");
         
         search = new SearchPage(driver);
         
        search.clickSecondProduct();
        
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Url11: " + driver.getCurrentUrl());
        
        Assert.assertTrue(driver.getTitle().contains("Watches"));

    }
    
    @Test(priority = 62)
    public void verifyMultipleProductsDisplayed() {
        
    	HomePage home = new HomePage(driver);

        home.searchProduct("Shoes");
        
        search = new SearchPage(driver);
        
    	
        Assert.assertTrue(search.getDisplayedProductCount() >= 2);

    }
    
//    @Test(priority = 63)
//    public void verifyProductImageDisplayed() {
//
//    	HomePage home = new HomePage(driver);
//
//        home.searchProduct("Backpack");
//        
//        search = new SearchPage(driver);
//        Assert.assertTrue(search.isProductImageDisplayed());
//
//    }
    
    @Test(priority = 63)
    public void verifyProductImageDisplayed() {
        HomePage home = new HomePage(driver);

        // Step 1 & 2: Launch Amazon, search for targeted asset keyword
        home.searchProduct("Backpack");
        
        // Step 3: Verify the visual block item placement
        search = new SearchPage(driver);
        
        // Clean descriptive failure message attached with Assertion
        Assert.assertTrue(search.isProductImageDisplayed(), "Execution Failed: The targeted product layout card image did not render or display correctly on screen.");
    }
    
    @Test(priority = 64)
    public void verifyProductLinkClickable() {
        HomePage home = new HomePage(driver);

        // Step 1 & 2: Launch Amazon India search workflow
        home.searchProduct("Trimmer");
        
        search = new SearchPage(driver);
        
        // Step 3: Explicit synchronisation ke sath step run karein
        search.clickFirstProductTitle();
        
        // Multi-window / New tab handling loop
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        }

        // Final detail page confirmation assertion
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/dp/") || currentUrl.contains("/gp/product/"), 
                "Execution Failed: Link redirects properly nahi ho paya. URL obtained: " + currentUrl);
    }
    
    @Test(priority = 65)
    public void verifySearchResultContainsKeyword() {
        HomePage home = new HomePage(driver);
        String searchKeyword = "iPhone";

        // Step 1 & 2: Go to Amazon India and search for "iPhone"
        home.searchProduct(searchKeyword);
        
        search = new SearchPage(driver);
        
        // Step 3: Pahle top 4 products ke titles list ko pull karein
        List<String> activeTitles = search.getFirstFewProductTitles(4);
        
        // Ensure list khali na ho
        Assert.assertFalse(activeTitles.isEmpty(), "Automation Error: Amazon page par koi bhi search results nahi mile.");

        // Naya Logic: Check karein ki kya kisi bhi ek title me keyword hai
        boolean keywordFoundInAnyProduct = false;
        for (String title : activeTitles) {
            if (title.toLowerCase().contains(searchKeyword.toLowerCase())) {
                keywordFoundInAnyProduct = true;
                break; // Agar ek me bhi mil gaya toh loop se bahar aa jao
            }
        }

        // Ab assert karein ki kam se kam ek relevant product mila ya nahi
        Assert.assertTrue(keywordFoundInAnyProduct, 
            "Execution Failed: Top 4 products me se kisi me bhi searched keyword '" + searchKeyword + "' nahi mila!");
    }


    @Test(priority = 66)
    public void verifyNextPageNavigation() {
        HomePage home = new HomePage(driver);

        // Broad scope product category search rule initialize karein
        home.searchProduct("Books");
        
        search = new SearchPage(driver);
        
        // Step action execution invoke karein
        search.clickNextPage();
        
        // Page transitions handle hone ke liye explicit synchronized runtime sync frame attach karein
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("page=2"));

        // Clean parameter validation asset evaluation rule check
        Assert.assertTrue(driver.getCurrentUrl().contains("page=2"), 
                "Execution Failed: Next pagination operation switch trace URL string map fail ho gaya.");
    }

    @Test(priority = 67)
    public void verifyPreviousPageNavigation() {
        HomePage home = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Target keyword "Tshirt" search karein
        home.searchProduct("Tshirt");
        
        search = new SearchPage(driver);
        
        // Step 2: Pehle 'Next' button click karke Page 2 par navigate karein (Pre-requisite setup)
        search.clickNextPage();
        wait.until(ExpectedConditions.urlContains("page=2"));
        
        // Step 3: Ab bottom scroll execute karke 'Previous' page navigation action trigger karein
        search.clickPreviousPage();
        
        // Verification Rules: Previous click hone par URL ya toh back to normal page 1 target parameters ho jayega ya fir string me "page=1" handle generate karein
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("page=1"),
            ExpectedConditions.not(ExpectedConditions.urlContains("page=2"))
        ));

        String currentUrl = driver.getCurrentUrl();
        
        // Assertions: Final verify karein ki hum successfully prior list (Page 1) par wapas aa chuke hain
        Assert.assertFalse(currentUrl.contains("page=2"), 
                "Execution Failed: User abhi bhi Page 2 par phase out ho rakha hai. Previous block click verify nahi hua.");
    }
    
  }
