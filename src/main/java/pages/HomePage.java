package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id="nav-link-accountList")
    WebElement signIn;

    public void clickSignIn() {

        click(signIn);

    }
	
	
}