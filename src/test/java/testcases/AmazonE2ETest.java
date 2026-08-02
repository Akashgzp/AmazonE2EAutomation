package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class AmazonE2ETest extends BaseTest {

	@Test
	public void verifyAmazonFlow() {

	    HomePage home = new HomePage(driver);
//	    home.clickSignIn();

//	    LoginPage login = new LoginPage(driver);
//	    login.enterEmail("8127196607");
//	    login.clickContinue();
//	    login.enterPassword("123456");
//	    login.clickSignIn();

	    SearchPage search = new SearchPage(driver);
//	    search.searchProduct("Samsung");

	    // Open First Product
        ProductPage product = new ProductPage(driver);
        product.openFirstProduct();

        // Verify Product
        String productTitle = product.getProductTitle();
        System.out.println("Product Title : " + productTitle);
        Assert.assertTrue(productTitle.toLowerCase().contains("samsung"));


        // CartPage Open
        CartPage cart = new CartPage(driver);
        cart.clickAddToCart();
        
        
	}
}
