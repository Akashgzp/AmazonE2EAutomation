package dataprovider;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTestDataDriven extends BaseTest{

	@Test(dataProvider="LoginData",
		      dataProviderClass=LoginData.class)

		public void verifyLogin(String email,
		                        String password){

		    LoginPage login =

		            new LoginPage(driver);

		    login.enterEmail(email);

		    login.clickContinue();

		    login.enterPassword(password);

		    login.clickSignIn();

		}
}
