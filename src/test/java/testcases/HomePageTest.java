package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest{

	@Test
	public void verifyHomePage() {
		
		 // Step 1 : Home Page
        HomePage home = new HomePage(driver);
        home.clickSignIn();
        System.out.println("Poll SCM Test");
	}
}
