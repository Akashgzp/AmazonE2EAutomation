package testcases;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    
    @Test
    public void verifyLogin() {

        HomePage home = new HomePage(driver);

        home.clickSignIn();

        LoginPage login = new LoginPage(driver);

        login.enterEmail("8127196607");
        login.clickContinue();
        login.enterPassword("123456");
        login.clickSignIn();
        
     // Login Feature Branch
        System.out.println("Login Feature Branch");
    }
}