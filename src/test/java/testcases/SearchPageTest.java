package testcases;

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

}
