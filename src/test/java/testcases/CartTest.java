package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class CartTest extends BaseTest {
    
	@Test
	public void verifyCart() {
		
		 HomePage home = new HomePage(driver);

//	        home.clickSignIn();
//
//	        LoginPage login = new LoginPage(driver);
//
//	        login.enterEmail("8127196607");
//	        login.clickContinue();
//	        login.enterPassword("123456");
//	        login.clickSignIn();
	        
		    //  Search Product
      SearchPage search = new SearchPage(driver);
      search.searchProduct("Samsung Mobile");

     // Open First Product
     ProductPage product = new ProductPage(driver);
     product.openFirstProduct();

     // Verify Product
     String productTitle = product.getProductTitle();
     System.out.println("Product Title : " + productTitle);

     Assert.assertTrue(productTitle.toLowerCase().contains("samsung"));

		//  Open Cart
        CartPage cart = new CartPage(driver);
        cart.clickAddToCart();
	}
}
