package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchPageTest extends BaseTest {

	@Test
	public void VerifySearch() {
		
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
	}
}
